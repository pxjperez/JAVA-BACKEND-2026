package edu.cibertec.controller;

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

    @RequestMapping("/")
    public ModelAndView mantenimientoUsuarios() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mantenimientoUsuarios");
        modelAndView.addObject("listaUsuarios", usuarioService.listarUsuarios());
        return modelAndView;
    }

    @RequestMapping("/nuevoUsuario")
    public ModelAndView nuevoUsuario() {
        UsuarioEntity usuario = new UsuarioEntity(null,"JPEREZABC","123456", "Juan Perez",null,1,null);
		usuarioService.registrarUsuario(usuario);
		System.out.println("Usuario registrado: " + usuario);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mantenimientoUsuarios");
        modelAndView.addObject("listaUsuarios", usuarioService.listarUsuarios());
        return modelAndView;
    }

    @RequestMapping("/eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mantenimientoUsuarios");
        modelAndView.addObject("listaUsuarios", usuarioService.listarUsuarios());
        return modelAndView;
    }
}