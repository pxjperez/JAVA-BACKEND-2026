package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @RequestMapping("/admin/mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuario() {
        return new ModelAndView("admin/mantenimientoUsuarios", "listaUsuarios", usuarioService.listarUsuarios());
    }
    
}
