package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{idUsuario}")    
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioEntity> obtenerUsuario(@PathVariable Integer idUsuario){
        return ResponseEntity.ok(usuarioService.obtenerUsuario(idUsuario));
    }
}
