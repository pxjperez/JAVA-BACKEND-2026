package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import lombok.extern.log4j.Log4j2;

@Controller
@SessionAttributes({"usuario", "mensajeBienvenida"})
@Log4j2 //@log @Log4j2, @Slf4j, @Log4j, @CommonsLog
public class HomeController {
    @RequestMapping("/principal")
    public String principal() {
        log.fatal("Accediendo a la página principal");
        return "principal";
    }

    @RequestMapping("/generarError")
    public String generarError() {
        log.error("Generando un error intencional");
        throw new RuntimeException("Acceso no autorizado - Logout");
        //return "login";
    }
}
