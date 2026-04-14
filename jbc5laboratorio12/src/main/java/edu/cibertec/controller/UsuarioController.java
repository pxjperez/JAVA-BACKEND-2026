package edu.cibertec.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="api/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Api para gestionar usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Listar usuarios")
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("{idUsuario}")
    @Operation(summary = "Obtener usuarios")
    public UsuarioEntity obtenerUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.obtenerUsuario(idUsuario);
    }

    @PostMapping
    @Operation(summary = "Registrar usuarios")
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PutMapping("{idUsuario}")
    @Operation(summary = "Actualizar usuarios")
    public UsuarioEntity actualizarUsuario(@PathVariable Integer idUsuario, UsuarioEntity usuario) {
        usuario.setIdUsuario(idUsuario);
        return usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("{idUsuario}")
    @Operation(summary = "Eliminar usuarios")
    public UsuarioEntity eliminarUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.eliminarUsuario(idUsuario);
    }


    @GetMapping(value = "/xml", produces =MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Listar usuarios en XML")
    public List<UsuarioEntity> listarUsuariosXml() {
        return usuarioService.listarUsuarios();
    }
    
}
