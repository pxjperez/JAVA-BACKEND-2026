package edu.cibertec.service;

import edu.cibertec.dto.ProductoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ProductoService {
    public Flux<ProductoDTO> listarProductos();
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto);
    public Mono<ProductoDTO> registrarProducto(ProductoDTO producto);
    public Mono<ProductoDTO> actualizarProducto(ProductoDTO producto);
    public Mono<Void> eliminarProducto(Integer idProducto);
}
