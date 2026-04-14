package edu.cibertec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioService.listaUsuarios();
    }
    
    @GetMapping("/{idUsuario}")
    public UsuarioEntity obtenerUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.obtenerUsuario(idUsuario);
    }

    @PostMapping
    public UsuarioEntity registrarUsuario(@RequestBody UsuarioEntity usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PutMapping("/{idUsuario}")
    public UsuarioEntity actualizarUsuario(@PathVariable Integer idUsuario, UsuarioEntity usuario) {
        return usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable Integer idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
    }

    
    @GetMapping("/test")
    public UsuarioEntity listTest(UsuarioEntity usuario) {
        return usuarioService.registrarUsuario(usuario);
    }
}
