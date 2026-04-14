package edu.cibertec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import edu.cibertec.entity.ErrorEntity;
import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value="api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Api para gestionar usuarios")
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Value("${server.port}")
    private String puerto;

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
    @PreAuthorize("permitAll()")
    //@PreAuthorize(hasRole('ADMIN')) // Solo los usuarios con el rol ADMIN pueden acceder a este endpoint  
    //@Secured("ADMIN") // Solo los usuarios con el rol ADMIN pueden acceder a este endpoint, se puede colocar el nombre del rol sin el prefijo ROLE_ o con el prefijo ROLE_
    //Se puede tener el ResponseEntity<?> de manera generica pero en el swagger se muestra como un objeto generico, si se quiere mostrar el tipo de dato se puede colocar ResponseEntity<List<UsuarioEntity>>
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {
        try {
            List<UsuarioEntity> listaUsuarios = usuarioService.listarUsuarios();
            listaUsuarios.forEach(usuario -> {
                usuario.add(linkTo(methodOn(UsuarioController.class).obtenerUsuario(usuario.getIdUsuario())).withRel("Usuario"));
            });
            log.info("Se ejecuto listarUsuarios desde el puerto: " + puerto);
            return ResponseEntity.ok(listaUsuarios);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al listar usuarios", ex);
        }
    }

    @GetMapping("{idUsuario}")
    @Operation(summary = "Obtener usuarios")
    @Secured("ADMIN") 
    public ResponseEntity<UsuarioEntity> obtenerUsuario(@PathVariable Integer idUsuario) {
        try {
            log.info("Se ejecuto obtenerUsuario desde el puerto: " + puerto);
            return ResponseEntity.ok(usuarioService.obtenerUsuario(idUsuario));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener usuario con id: " + idUsuario, ex);
        } 
    }


    @PostMapping
    @Operation(summary = "Registrar usuarios")
    public ResponseEntity<UsuarioEntity> registrarUsuario(@RequestBody UsuarioEntity usuario){
        try {
            log.info("Se ejecuto registrarUsuario desde el puerto: " + puerto);
            return ResponseEntity.created(new URI("api/usuarios/" + usuarioService.registrarUsuario(usuario).getIdUsuario())).build(); 
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al registrar usuario", ex);
        }
    }

    @PutMapping("{idUsuario}")
    @Operation(summary = "Actualizar usuarios")
    public ResponseEntity<UsuarioEntity> actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioEntity usuario) {
        try {
            usuario.setIdUsuario(idUsuario);
            usuarioService.actualizarUsuario(usuario);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("api/usuarios/" + idUsuario));
            log.info("Se ejecuto actualizarUsuario desde el puerto: " + puerto);
            return  new ResponseEntity<>(null, headers, HttpStatus.OK);
            } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al actualizar usuario con id: " + idUsuario, ex);
        }
        
    }

    @DeleteMapping("{idUsuario}")
    @Operation(summary = "Eliminar usuarios")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer idUsuario) {
         UsuarioEntity usuario = usuarioService.eliminarUsuario(idUsuario);
         if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario con id: " + idUsuario + " no encontrado");
         }
         log.info("Se ejecuto eliminarUsuario desde el puerto: " + puerto);
         return ResponseEntity.noContent().build();
    }
}
