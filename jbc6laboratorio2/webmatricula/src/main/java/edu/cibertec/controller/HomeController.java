package edu.cibertec.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, Principal principal, Model model) {
        // Si el usuario ya ha iniciado sesión, redirigir a la página de inicio        // Si hay error en el login, mostrar mensaje de error
        if(error != null) {
            model.addAttribute("msgError", "Usuario o contraseña incorrectos");
        }
        return "login";
    }
}

