package edu.cibertec.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.CursoEntity;
import edu.cibertec.service.CursoService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;
    
    @RequestMapping("mantenimientoCursos")
    public String mantenimientoCursos(){
        return "/admin/curso/mantenimientoCursos";
    }

    @RequestMapping("formularioNuevoCurso")
    public ModelAndView formularioNuevoCurso(){
        ModelAndView mv = new ModelAndView("/admin/curso/formularioCurso");
        mv.addObject("titulo", "Registrar Curso");
        mv.addObject("cursoBean", new CursoEntity());
        return mv;
    }

    @RequestMapping("formularioActualizarCurso")
    public ModelAndView formularioActualizarCurso(Integer idCurso){
        ModelAndView mv = new ModelAndView("/admin/curso/formularioCurso");
        mv.addObject("titulo", "Actualizar Curso");
        mv.addObject("cursoBean", cursoService.obtenerCurso(idCurso));
        return mv;
    }

    @RequestMapping("registrarCurso")
    public String registrarCurso(CursoEntity curso){
        if(curso.getIdCurso()==null){
            cursoService.registrarCurso(curso);
        }else{
            cursoService.actualizarCurso(curso);
        }
        return "redirect:/mantenimientoCursos";
    }

    @RequestMapping("eliminarCurso")
    public String eliminarCurso(Integer idCurso){
        cursoService.eliminarCurso(idCurso);
        return "redirect:/mantenimientoCursos";
    }
    
    @RequestMapping("buscarCursos")
    public ModelAndView buscarCursos(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/admin/curso/mantenimientoCursos");
        String tipo = request.getParameter("tipoConsulta");
        if(tipo!=null){
            switch (tipo) {
                case "LISTARPORNOMBRECURSO":
                    mv.addObject("listaCursos",cursoService.listarCursosPorNombreCurso(request.getParameter("nombreCurso1")));
                    break;
                case "LISTARPORNOMBRECURSOANDALUMNOSMINIMO":
                    mv.addObject("listaCursos",cursoService.listarCursosPorNombreCursoAndAlumnosMinimo(request.getParameter("nombreCurso2"),Integer.valueOf(request.getParameter("alumnosMinimo"))));
                    break;
                case "LISTARPORESTADO":
                    mv.addObject("listaCursos",cursoService.consultarPorEstado(Integer.valueOf(request.getParameter("estado"))));
                    break;
                case "LISTARABIERTOINCOMPLETO":
                    mv.addObject("listaCursos",cursoService.abiertoIncompleto());
                    break;
                case "LISTARABIERTOINCOMPLETONATIVO":
                    mv.addObject("listaCursos",cursoService.abiertoIncompletoNativo());
                    break;
                case "LISTARPORFECHA":
                    try {
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = formater.parse(request.getParameter("fecha"));
                        mv.addObject("listaCursos", cursoService.consultaPorFecha(date));
                    } catch (Exception e) {
                        System.out.println("Ocurrio un error en la fecha");
                        mv.addObject("listaCursos", null);
                    }
                    break;
                case "LISTARPORFALTANTE":
                    mv.addObject("listaCursos",cursoService.consultaFaltantes(Integer.valueOf(request.getParameter("cantidadAlumnos"))));
                    break;
                case "LISTARPORNOMBRE":
                    mv.addObject("listaCursos",cursoService.consultaPorNombre(request.getParameter("nombreCurso3")));
                    break;
            }
        }else{
            mv.addObject("listaCursos", null);
        }
        
        return mv;
    }
    
    
}
