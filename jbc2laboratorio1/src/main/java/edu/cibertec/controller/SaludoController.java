package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludoController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
