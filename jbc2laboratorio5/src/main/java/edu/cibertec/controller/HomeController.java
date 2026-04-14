package edu.cibertec.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Scope("usuario")
public class HomeController {

    //El controlador devuelve la vista y datos(Modelo)
    //Le estamos mandado un parametro por la URL (PathVariable)
    @RequestMapping("/home") // http://localhost:8080/jbc2laboratorio3-1/home?nombre=Juan
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

}
