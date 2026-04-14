package edu.cibertec.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final static int TAMANO_PAGINA=5;



    @RequestMapping("/mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios(@RequestParam(name="pag", required=false) Integer pag, @RequestParam(name="orden", required=false) String orden){
        ModelAndView mav = new ModelAndView();
        pag = (pag==null || pag<1)?0:pag;
        Pageable pageable = PageRequest.of(pag, TAMANO_PAGINA);
        if(orden!=null && !orden.isEmpty()){
            pageable = PageRequest.of(pag, TAMANO_PAGINA,  Sort.by(orden).ascending());
        }
        Integer cantidadPaginas = (int) Math.ceil((double)usuarioService.buscarUsuario("").size() / TAMANO_PAGINA);
        mav.setViewName("admin/usuario/mantenimientoUsuarios");
        mav.addObject("cantidadPaginas",cantidadPaginas);
        mav.addObject("listaUsuarios", usuarioService.buscarUsuario("", pageable));
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

    @PostMapping("registrarUsuario")
    public ModelAndView registrarUsuario(@RequestParam(name = "archivo", required = false) MultipartFile archivo, @Validated @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resultadoValidado){
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
                        UsuarioEntity usuarioExistente = usuarioService.obtenerUsuario(usuario.getIdUsuario());
                        usuario.setFoto(usuarioExistente.getFoto());
                    }
                    UsuarioEntity usuarioTemp = usuarioService.actualizarUsuario(usuario);
                    if(usuarioTemp!=null){
                        mv.setViewName("redirect:/mantenimientoUsuarios?msgExito=Se actualizo con exito");
                    }else{
                        mv.addObject("usuarioBean", usuario);
                        mv.addObject("msgError", "Ocurrio un error al momento de actualizar");
                    }
                }else{
                    if(archivo!=null && !archivo.isEmpty()){
                        byte[] bytesArchivo = archivo.getBytes();
                        usuario.setFoto(bytesArchivo);
                    }
                    UsuarioEntity usuarioTemp = usuarioService.registrarUsuario(usuario);
                    if(usuarioTemp!=null){
                        mv.setViewName("redirect:/mantenimientoUsuarios?msgExito=Se registro con exito");
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
        mv.setViewName("redirect:/mantenimientoUsuarios?msgExito=Se elimino con exito");
        return mv;
    }

    @RequestMapping("/buscarUsuario")
    public ModelAndView buscarUsuario(@RequestParam(name="pag", required=false) Integer pag, @RequestParam(name="orden", required=false) String orden, String user){
         ModelAndView mav = new ModelAndView();
        pag = (pag==null || pag<1)?0:pag;
        Pageable pageable = PageRequest.of(pag, TAMANO_PAGINA);
        if(orden!=null && !orden.isEmpty()){
            pageable = PageRequest.of(pag, TAMANO_PAGINA,  Sort.by(orden).ascending());
        }
        Integer cantidadPaginas = (int) Math.ceil((double)usuarioService.buscarUsuario(user).size() / TAMANO_PAGINA);
        mav.setViewName("admin/usuario/mantenimientoUsuarios");
        mav.addObject("cantidadPaginas",cantidadPaginas);
        mav.addObject("listaUsuarios", usuarioService.buscarUsuario(user, pageable));
        return mav;
    }
}
