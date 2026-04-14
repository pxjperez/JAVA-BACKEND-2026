package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario) {
        ModelAndView mav = new ModelAndView();
        UsuarioEntity usuarioValidado = usuarioService.validarUsuario(usuario);
        if (usuarioValidado != null) {
            mav.setViewName("home");
            mav.addObject("usuario", usuarioValidado);
        } else {
            mav.setViewName("login");
            mav.addObject("error", "Credenciales inválidas");
        }
        return mav;
    }
}
