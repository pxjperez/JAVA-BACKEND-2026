package edu.cibertec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoEntity> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("{idCurso}")
    public CursoEntity obtenerCurso(@PathVariable("idCurso") Integer idCurso, HttpServletRequest req) {
        String usuario = req.getParameter("Username");
        String passsword = req.getParameter("Password");
        if (usuario.equals("cliente") && passsword.equals("clave")) {
            return cursoService.obtenerCurso(idCurso);
        }else{
            throw new IllegalArgumentException("Credenciales incorrectas");
        }
    }
    
}
