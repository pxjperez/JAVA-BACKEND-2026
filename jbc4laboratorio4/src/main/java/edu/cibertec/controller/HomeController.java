package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"usuario", "mensajeBienvenida"})
public class HomeController {

    @RequestMapping("/principal")
    public String principal() {
        return "principal";
    }

    @RequestMapping("/generarError")
    public String generarError() {
        throw new RuntimeException("Acceso no autorizado - Logout");
        //return "login";
    }
}
