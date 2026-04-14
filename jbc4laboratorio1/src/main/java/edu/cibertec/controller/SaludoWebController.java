package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;

@Controller
public class SaludoWebController {
    @RequestMapping("/")
    public ModelAndView saludo(UsuarioEntity usuario) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("usuario", usuario);
        return mav;
    }
}
