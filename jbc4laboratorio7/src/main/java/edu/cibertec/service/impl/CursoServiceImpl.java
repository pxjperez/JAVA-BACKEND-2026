package edu.cibertec.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.repository.CursoRepository;
import edu.cibertec.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursosPorNombreCurso(String nombreCurso) {
        return cursoRepository.consultaPorNombre(nombreCurso);
    }

    @Override
    public List<CursoEntity> listarCursosPorNombreCursoAndAlumnosMinimo(String nombreCurso, Integer alumnosMinimo) {
      
        return cursoRepository.findByNombreCursoContainingIgnoreCaseAndAlumnosMinimo(nombreCurso, alumnosMinimo);
    }

    @Override
    public List<CursoEntity> consultarPorEstado(Integer estado) {
        return cursoRepository.consultarPorEstado(estado);
    }

    @Override
    public List<CursoEntity> abiertoIncompleto() {
        return cursoRepository.abiertoIncompleto();
    }

    @Override
    public List<CursoEntity> abiertoIncompletoNativo() {
        return cursoRepository.abiertoIncompletoNativo();
    }

    @Override
    public List<CursoEntity> consultaPorFecha(Date fecha) {
        return cursoRepository.consultarPorFecha(fecha);
    }

    @Override
    public List<CursoEntity> consultaFaltantes(Integer cantidad) {
        return cursoRepository.consultarFaltantes(cantidad);
    }

    @Override
    public List<CursoEntity> consultaPorNombre(String nombre) {
        return cursoRepository.consultaPorNombre(nombre);
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = obtenerCurso(idCurso);
        if (curso != null) {
            curso.setEstado(0);
            cursoRepository.save(curso);
        }
        return curso;
    }
    
}
