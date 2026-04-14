package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario){
        ModelAndView mav = new ModelAndView();
        UsuarioEntity usuarioValidado = this.usuarioService.validarUsuario(usuario);
        if(usuarioValidado != null){
            mav.setViewName("home");
            mav.addObject("usuario", usuarioValidado);
        }else{
            mav.setViewName("login");
            mav.addObject("msgError", "Credenciales incorrectas, intente nuevamente.");
        }
        return mav;
    }

    @RequestMapping("/mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/usuario/mantenimientoUsuarios");
        mav.addObject("listaUsuarios", this.usuarioService.listarUsuarios());
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
    public ModelAndView registrarUsuario(@RequestParam(name = "archivo", required = false) MultipartFile archivo, @Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resultadoValidado){
        ModelAndView mv = new ModelAndView("admin/usuario/formularioUsuario");
        try {
            if(resultadoValidado.hasErrors()){
                mv.addObject("usuarioBean", usuario);
                mv.addObject("msgError", "Los datos ingresados no son los correctos");
            }else{
                if(usuario!=null && usuario.getIdUsuario()!=null && usuario.getIdUsuario()>0){
                    if(archivo!=null && !archivo.isEmpty()){
                        byte[] bytesArchivo = archivo.getBytes();
                        usuario.setFoto(bytesArchivo);
                    }else{
                        UsuarioEntity usuarioExistente = this.usuarioService.obtenerUsuario(usuario.getIdUsuario());
                        usuario.setFoto(usuarioExistente.getFoto());
                    }
                    UsuarioEntity usuarioTemp = this.usuarioService.actualizarUsuario(usuario);
                    if(usuarioTemp!=null){
                        mv.setViewName("admin/usuario/mantenimientoUsuarios");
                        mv.addObject("listaUsuarios", this.usuarioService.listarUsuarios());
                        mv.addObject("msgExito","Se actualizo con exito");
                    }else{
                        mv.addObject("usuarioBean", usuario);
                        mv.addObject("msgError", "Ocurrio un error al momento de actualizar");
                    }
                }else{
                    if(archivo!=null && !archivo.isEmpty()){
                        byte[] bytesArchivo = archivo.getBytes();
                        usuario.setFoto(bytesArchivo);
                    }
                    UsuarioEntity usuarioTemp = this.usuarioService.registrarUsuario(usuario);
                    if(usuarioTemp!=null){
                        mv.setViewName("admin/usuario/mantenimientoUsuarios");
                        mv.addObject("listaUsuarios", this.usuarioService.listarUsuarios());
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
        this.usuarioService.eliminarUsuario(idUsuario);
        mv.setViewName("admin/usuario/mantenimientoUsuarios");
        mv.addObject("listaUsuarios", this.usuarioService.listarUsuarios());
        mv.addObject("msgExito","Se elimino con exito");
        return mv;
    }

    
}
