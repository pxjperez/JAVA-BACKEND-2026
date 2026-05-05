package edu.cibertec.service.impl;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public Flux<ProductoDTO> listarProductos() {
        return productoRepository.listarProductos();
    }

    @Override
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto) {
        return productoRepository.obtenerProducto(idProducto);
    }

    @Override
    public Mono<ProductoDTO> registrarProducto(ProductoDTO producto) {
        return productoRepository.registrarProducto(producto);
    }

    @Override
    public Mono<ProductoDTO> actualizarProducto(ProductoDTO producto) {
        return productoRepository.actualizarProducto(producto);
    }

    @Override
    public Mono<Void> eliminarProducto(Integer idProducto) {
        return productoRepository.eliminarProducto(idProducto); 
    }
}
