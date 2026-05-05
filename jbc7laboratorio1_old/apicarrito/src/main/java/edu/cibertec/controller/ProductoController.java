package edu.cibertec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@Tag(name = "Producto", description = "Api para gestionar productos")
public class ProductoController {
    private final ProductoService  productoService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los productos registrados")
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{idProducto}")
    @Operation(summary = "Obtener un producto por ID", description = "Devuelve un producto específico según su ID")
    public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Integer idProducto) {
        return ResponseEntity.ok(productoService.obtenerProducto(idProducto));
    }
}
