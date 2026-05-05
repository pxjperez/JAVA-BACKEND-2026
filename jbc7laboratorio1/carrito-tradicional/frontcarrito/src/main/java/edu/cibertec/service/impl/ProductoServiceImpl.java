package edu.cibertec.service.impl;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.listarProductos();
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return productoRepository.obtenerProducto(idProducto);
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        return productoRepository.registrarProducto(producto);
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) {
        return productoRepository.actualizarProducto(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoRepository.eliminarProducto(idProducto);
    }
}
