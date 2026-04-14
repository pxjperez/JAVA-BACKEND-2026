package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.service.CursoService;
import edu.cibertec.service.MatriculaService;
import edu.cibertec.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MatriculaController {
    private final MatriculaService matriculaService;
    private final UsuarioService usuarioService;
    private final CursoService cursoService;

    @RequestMapping("mantenimientoMatriculaJs") //Controlador que expone las vistas
    public String mantenimientoMatriculaJs(){
        return "/admin/matricula/mantenimientoMatriculaJs";
    }

    @RequestMapping("formularioNuevaMatricula")//Si voy a trajar solo con java deberia de utilizar esta forma vista y datos
    public ModelAndView formularioNuevaMatricula(){
        ModelAndView mv = new ModelAndView("/admin/matricula/formularioMatricula");
        mv.addObject("titulo", "Registrar Matricula");
        mv.addObject("matriculaBean", new MatriculaEntity());
        mv.addObject("listaCursos", cursoService.consultarPorEstado(1));
        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
        return mv;
    }

    @RequestMapping("registrarMatricula")//Si voy a trajar solo con java deberia de utilizar esta forma vista y datos
    public ModelAndView registrarMatricula(@ModelAttribute("matriculaBean") MatriculaEntity matriculaBean){
        ModelAndView mv = new ModelAndView("/admin/matricula/mantenimientoMatricula");
        matriculaService.registrarMatricula(matriculaBean);
        mv.addObject("mensajeError", "Matricula registrada correctamente");
        mv.setViewName("redirect:/mantenimientoMatricula");
        return mv;
    }

    @RequestMapping("mantenimientoMatricula")//Si voy a trajar solo con java deberia de utilizar esta forma vista y datos
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
