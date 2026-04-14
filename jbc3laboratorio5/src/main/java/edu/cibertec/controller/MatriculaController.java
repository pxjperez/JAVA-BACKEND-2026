package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.service.MatriculaService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MatriculaController {
    private final MatriculaService matriculaService;

    @RequestMapping("mantenimientoMatricula")
    public ModelAndView mantenimientoMatricula(){
        ModelAndView mv = new ModelAndView("/admin/matricula/mantenimientoMatricula");
        mv.addObject("listaMatriculas", matriculaService.listarMatriculas());
        return mv;
    }

    @RequestMapping("mantenimientoMatriculaPersonalizada")
    public ModelAndView mantenimientoMatriculaPersonalizada(){
        ModelAndView mv = new ModelAndView("/admin/matricula/mantenimientoMatriculaPersonalizada");
        mv.addObject("listaMatriculas", matriculaService.listarMatriculasPersonalizada());
        return mv;
    }

    @RequestMapping("mantenimientoMatriculaPersonalizadaNativa")
    public ModelAndView mantenimientoMatriculaPersonalizadaNativa(){
        ModelAndView mv = new ModelAndView("/admin/matricula/mantenimientoMatriculaPersonalizadaNativa");
        mv.addObject("listaMatriculas", matriculaService.listarMatriculasPersonalizadaNativa());
        return mv;
    }
}
