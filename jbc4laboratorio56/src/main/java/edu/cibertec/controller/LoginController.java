package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"usuario", "mensajeBienvenida"})
public class LoginController {

    private final UsuarioService usuarioService;

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus status) {
        // Limpia @SessionAttributes
        status.setComplete();
        // Invalida sesión HTTP
        session.invalidate();
        return "login";
    }


    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        UsuarioEntity usuarioValidado = usuarioService.validarUsuario(usuario);
        if (usuarioValidado != null) {
            modelAndView.setViewName("redirect:principal");
            session.setAttribute("usuario", usuarioValidado);
            //modelAndView.addObject("usuario", usuarioValidado);
            session.setAttribute("mensajeBienvenida", mensajeBienvenida);
            //modelAndView.addObject("mensajeBienvenida", mensajeBienvenida);
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("msgError", "Usuario o contraseña incorrectos");
        }
        return modelAndView;
    }
}