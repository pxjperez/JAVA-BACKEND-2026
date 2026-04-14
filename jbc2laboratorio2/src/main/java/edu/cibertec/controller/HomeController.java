package edu.cibertec.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    //El controlador solo devuelve la vista
    @RequestMapping("/home")
    public String home() {
        return "home"; // Retorna el nombre de la vista (home.jsp)
    }

    //El controlador devuelve la vista y datos(Modelo)
    //Le estamos mandado un parametro por la URL (PathVariable)
    @RequestMapping("/home/{nombre}")
    public ModelAndView home(@PathVariable("nombre") String nombre) {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("nombre", nombre);
        return mav;
    }

    //Le estamos mandado dos parametros por la URL (PathVariable) y parametros (RequestParam) (Data Binding direto)
    @RequestMapping("/home/{nombre}/{edad}")// => /home/Juan/21?nacionalidad=Peruana
    public ModelAndView home(@PathVariable("nombre") String nombre, @PathVariable("edad") int edad, String nacionalidad) {
        //ModelAndView mav = new ModelAndView("home");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("nombre", nombre);
        mav.addObject("edad", edad);
        mav.addObject("nacionalidad", nacionalidad);
        return mav;
    }

    //En este caso el parametro (RequestParam) (Data Binding direto)
    @RequestMapping("/homeNombre")// => /homeNombre?nombre=Juan
    public ModelAndView homeNombre(String nombre) {
        ModelAndView mav = new ModelAndView("home");
        //LOGICA DE NEGOCIO
        mav.addObject("nombre", nombre);
        return mav;
    }

    //El controlador devuelve la vista y datos(Modelo) usando Model
    //Con el RequestParam estamos personalizando el parametro que viene en la URL
    @RequestMapping("/bienvenida")// => /bienvenida?nombre=Juan
    public String bienvenida(@RequestParam(name="nombre",required = false ) String nombre, Model modelo) { //RequestParam se puede configurar la obligatoriedad del parametro
        modelo.addAttribute("nombre", nombre);
        return "bienvenida";
    }

    @RequestMapping("/bienvenida2")// => /bienvenida2?nombre=Juan
    public ModelAndView bienvenida2(HttpServletRequest request) { //RequestParam se puede configurar la obligatoriedad del parametro
        ModelAndView mav = new ModelAndView("bienvenida");
        String nombre = request.getParameter("nombre");
        mav.addObject("nombre", nombre);
        return mav;
    }

    //La forma mas utiliza es devolver el ModelAndView

}
