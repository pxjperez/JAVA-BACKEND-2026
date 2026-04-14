package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    private final KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.topico.nombre}")
    private String topico;
    
    @RequestMapping("/")
    public ModelAndView listarCursos(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mantenimientoCursos");
        mav.addObject("listaCursos", cursoService.listarCursos());
        return mav;
    }

    @RequestMapping("matricular")
    public ModelAndView matricular(Integer idCurso){
        ModelAndView mav = new ModelAndView();
        //Logica de registrar la matricula en el mismo sistema por base de datos

        //Logica para actualizar la cantidad de alumnos matriculados en el curso por un topico de kafka
        CursoEntity curso = cursoService.obtenerCurso(idCurso);
        kafkaTemplate.send(topico, curso);
        //Fin logica para actualizar la cantidad de alumnos matriculados en el curso por un topico de kafka
        mav.setViewName("redirect:/");
        return mav;
    }
}
