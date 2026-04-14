package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario) {
        ModelAndView mav = new ModelAndView();
        UsuarioEntity usuarioValidado = usuarioService.validarUsuario(usuario);
        if (usuarioValidado != null) {
            mav.setViewName("bienvenida");
            mav.addObject("usuario", usuarioValidado);
        } else {
            mav.setViewName("login");
            mav.addObject("error", "Credenciales inválidas");
        }
        return mav;
    }

    @RequestMapping("mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/usuario/mantenimientoUsuarios");
        mav.addObject("listaUsuarios", usuarioService.listarUsuarios());
        return mav;
    }

    @RequestMapping("formularioNuevoUsuario")
    public ModelAndView formularioNuevoUsuario(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/usuario/formularioUsuario");
        mv.addObject("usuarioBean", new UsuarioEntity());
        mv.addObject("titulo", "Nuevo Usuario");
        return mv;
    }

    @RequestMapping("formularioActualizarUsuario")
    public ModelAndView formularioActualizarUsuario(Integer idUsuario){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/usuario/formularioUsuario");
        mv.addObject("usuarioBean", usuarioService.obtenerUsuario(idUsuario));
        mv.addObject("titulo", "Actualizar Usuario");
        return mv;
    }

    @RequestMapping("registrarUsuario")
    public ModelAndView registrarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resultadoValidado){
        ModelAndView mv = new ModelAndView("admin/usuario/formularioUsuario");
        try {
            if(resultadoValidado.hasErrors()){
                mv.addObject("usuarioBean", usuario);
                mv.addObject("msgError", "Los datos ingresados no son los correctos");
            }else{
                if(usuario!=null && usuario.getIdUsuario()!=null && usuario.getIdUsuario()>0){
                    UsuarioEntity usuarioTemp = usuarioService.actualizarUsuario(usuario);
                    if(usuarioTemp!=null){
                        mv.setViewName("admin/usuario/mantenimientoUsuarios");
                        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
                        mv.addObject("msgExito","Se actualizo con exito");
                    }else{
                       mv.addObject("usuarioBean", usuario);
                       mv.addObject("msgError", "Ocurrio un error al momento de actualizar");
                    }
                }else{
                    UsuarioEntity usuarioTemp = usuarioService.registrarUsuario(usuario);
                    if(usuarioTemp!=null){
                        mv.setViewName("admin/usuario/mantenimientoUsuarios");
                        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
                         mv.addObject("msgExito","Se registro con exito");
                    }else{
                        mv.addObject("usuarioBean", usuario);
                        mv.addObject("msgError", "Ocurrio un error al momento de guardar");
                    }
                }
            }
        } catch (Exception ex) {
            mv.addObject("usuarioBean", usuario);
            ex.getStackTrace();
            mv.addObject("msgError", "Ocurrio un error en: "+ex.getLocalizedMessage());
        }
        return mv;
    }

    @RequestMapping("elinarUsuario")
    public ModelAndView elinarUsuario(Integer idUsuario){
        ModelAndView mv = new ModelAndView();
        usuarioService.eliminarUsuario(idUsuario);
        mv.setViewName("admin/usuario/mantenimientoUsuarios");
        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
        mv.addObject("msgExito","Se elimino con exito");
        return mv;
    }
}
