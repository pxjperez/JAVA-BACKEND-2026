package edu.cibertec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.UsuarioEntity;

@RestController//Se utiliza para exponer un recurso Json/xml/html
public class SaludoApiController {
    @RequestMapping("/saludo")
    public String saludo(UsuarioEntity usuario) {
        return "Hola Mundo desde Spring Boot para "+usuario.getNombreApellido();
    }
}
