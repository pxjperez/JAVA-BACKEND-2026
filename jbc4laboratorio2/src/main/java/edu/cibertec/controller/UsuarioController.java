package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario) {
        ModelAndView modelAndView = new ModelAndView();
        UsuarioEntity usuarioValidado = usuarioService.validarUsuario(usuario);
        if (usuarioValidado != null) {
            modelAndView.setViewName("principal");
            modelAndView.addObject("usuario", usuarioValidado);
            modelAndView.addObject("mensajeBienvenida", mensajeBienvenida);
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("msgError", "Usuario o contraseña incorrectos");
        }
        return modelAndView;
    }
}