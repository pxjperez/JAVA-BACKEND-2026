package edu.cibertec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Api para gestionar usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios registrados")
    public ResponseEntity<List<UsuarioDTO>> listarUsuario() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Obtener un usuario por ID", description = "Devuelve un usuario específico según su ID")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(usuarioService.obtenerUsuario(idUsuario));
    }
    
}
