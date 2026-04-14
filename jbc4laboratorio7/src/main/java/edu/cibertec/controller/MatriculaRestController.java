package edu.cibertec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.service.MatriculaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MatriculaRestController {
    private final MatriculaService matriculaService;
    @GetMapping("/api/matriculas") //Exponer los recursos JSON para ser utilziados en la vista
    public List<MatriculaEntity> listarMatriculas() {
        return matriculaService.listarMatriculas();
    }
}

