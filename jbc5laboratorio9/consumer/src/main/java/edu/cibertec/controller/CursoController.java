package edu.cibertec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.cibertec.service.CursoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @RequestMapping("actualizarCantidadAlumnosActualReactivo")
    public String actualizarCantidadAlumnosActualReactivo(Integer idCurso){
        cursoService.actualizarCantidadAlumnosActualReactivo();
        return "Actualizacion masiva realizada";
    }
}
