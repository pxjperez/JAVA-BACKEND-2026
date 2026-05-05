package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categorias", description = "Operaciones relacionadas con las categorías")
@Log
public class CategoriaController {
    private final CategoriaService categoriaService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public ResponseEntity<Flux<CategoriaDTO>> listarCategorias() {
        log.info("Listando categorías en el puerto: " + serverPort);
        Flux<CategoriaDTO> listaCategorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(listaCategorias);
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Mono<CategoriaDTO>> obtenerCategoria(@PathVariable Integer idCategoria) {
        Mono<CategoriaDTO> categoria = categoriaService.obtenerCategoria(idCategoria);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Mono<CategoriaDTO>> registrarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Mono<CategoriaDTO> categoriaNueva = categoriaService.registrarCategoria(categoriaDTO);
        return ResponseEntity.ok(categoriaNueva);
    }

    @PutMapping
    public ResponseEntity<Mono<CategoriaDTO>> actualizarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Mono<CategoriaDTO> categoriaActualizada = categoriaService.actualizarCategoria(categoriaDTO);
        return ResponseEntity.ok(categoriaActualizada);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Mono<Void>> eliminarCategoria(@PathVariable Integer idCategoria) {
        categoriaService.eliminarCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }
}
