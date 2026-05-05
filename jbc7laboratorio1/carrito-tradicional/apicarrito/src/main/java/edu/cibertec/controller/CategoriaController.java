package edu.cibertec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
@Tag(name = "Categoria", description = "Api para gestionar categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Obtener todas las categorias", description = "Devuelve una lista de todas las categorias registradas")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{idCategoria}")
    @Operation(summary = "Obtener una categoria por ID", description = "Devuelve una categoria específica según su ID")
    public ResponseEntity<CategoriaDTO> obtenerCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(categoriaService.obtenerCategoria(idCategoria));
    }

}
