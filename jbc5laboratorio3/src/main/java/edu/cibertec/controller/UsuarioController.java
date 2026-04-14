package edu.cibertec.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import edu.cibertec.entity.ErrorEntity;
import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Api para gestionar usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @ExceptionHandler(ResponseStatusException.class)
    private ResponseEntity<ErrorEntity> capturadorErrores(ResponseStatusException ex) {
        ErrorEntity error = new ErrorEntity();
        error.setCode(ex.getStatusCode().value());
        error.setStatus(ex.getStatusCode().toString());
        error.setMessage(ex.getReason());        
        HttpStatus statusCode =(HttpStatus) ex.getStatusCode();
        return ResponseEntity.status(statusCode).body(error);
    }


    @GetMapping
    @Operation(summary = "Listar usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioEntity> listarUsuarios() {
        try {
            return usuarioService.listarUsuarios();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al listar usuarios", ex);
        }
    }

    @GetMapping("{idUsuario}")
    @Operation(summary = "Obtener usuarios")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioEntity obtenerUsuario(@PathVariable Integer idUsuario) {
        try {
           return usuarioService.obtenerUsuario(idUsuario);
        } catch (Exception exception) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener usuario con id: " + idUsuario, exception);
        } 
    }

    /**
    @PostMapping
    @Operation(summary = "Registrar usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntity registrarUsuario(@RequestBody UsuarioEntity usuario) {
        usuarioService.registrarUsuario(usuario);
        return null;
    }
     */
    @PostMapping
    @Operation(summary = "Registrar usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarUsuario(@RequestBody UsuarioEntity usuario) {
        usuarioService.registrarUsuario(usuario);
    }

    @PutMapping("{idUsuario}")
    @Operation(summary = "Actualizar usuarios")
    @ResponseStatus(HttpStatus.OK)
    public void actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioEntity usuario) {
        usuario.setIdUsuario(idUsuario);
        usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("{idUsuario}")
    @Operation(summary = "Eliminar usuarios")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable Integer idUsuario) {
         UsuarioEntity usuario = usuarioService.eliminarUsuario(idUsuario);
         if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario con id: " + idUsuario + " no encontrado");
         }
    }
}
