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

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.service.ProductoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
@Log
public class ProductoController {
    private final ProductoService productoService;

    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping
    public ResponseEntity<Flux<ProductoDTO>> listarProductos() {
        log.info("Listando productos en el puerto: " + serverPort);
        Flux<ProductoDTO> listaProductos = productoService.listarProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Mono<ProductoDTO>> obtenerProducto(@PathVariable Integer idProducto) {
        Mono<ProductoDTO> producto = productoService.obtenerProducto(idProducto);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Mono<ProductoDTO>> registrarProducto(@RequestBody ProductoDTO productoDTO) {
        Mono<ProductoDTO> productoNuevo = productoService.registrarProducto(productoDTO);
        return ResponseEntity.ok(productoNuevo);
    }

    @PutMapping
    public ResponseEntity<Mono<ProductoDTO>> actualizarProducto(@RequestBody ProductoDTO productoDTO) {
        Mono<ProductoDTO> productoActualizado = productoService.actualizarProducto(productoDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Mono<Void>> eliminarProducto(@PathVariable Integer idProducto) {
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }
}
