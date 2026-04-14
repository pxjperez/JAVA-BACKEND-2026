package edu.cibertec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursorServiceImpl implements CursoService {

    private final KafkaConsumer<String, CursoEntity> consumer;

    @Value("${spring.kafka.topico.nombre}")
    private String topico;
    
    private boolean subscribed = false;
    private final  CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
    }


    @Override
    @KafkaListener(topics = "${spring.kafka.topico.nombre}", groupId = "${spring.kafka.consumer.group-id}")
    public void actualizarCantidadAlumnosActualProactivo(CursoEntity curso) {
        try {
            curso.setAlumnosActual(curso.getAlumnosActual()+1);
            cursoRepository.save(curso);
            System.out.println("Cantidad e alumnos actulizada: " + curso);
        } catch (Exception ex) {
            System.out.println("Error al actualizar la cantidad de alumnos: " + ex.getMessage());
        } 
    }

    @Override
    public void actualizarCantidadAlumnosActualReactivo() {
        try {
            if (!subscribed) {
                consumer.subscribe(List.of(topico));
                subscribed = true;
            }
            
            var records = consumer.poll(java.time.Duration.ofMillis(1000));
            
            for (var record : records) {
                CursoEntity curso = record.value();
                curso.setAlumnosActual(curso.getAlumnosActual()+1);
                cursoRepository.save(curso);
                System.out.println("Cantidad e alumnos actulizada: " + curso);
            }
        } catch (Exception ex) {
            System.out.println("Error al actualizar la cantidad de alumnos de manera masiva: " + ex.getMessage());
        }
        
    }
    
}
