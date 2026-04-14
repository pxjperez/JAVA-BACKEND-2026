package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoEntity registrarProducto(ProductoEntity producto) {
        //generar error para probar el after throwing
        //throw new RuntimeException("Error al registrar producto");
        return productoRepository.registrarProducto(producto);
    }

    @Override
    public ProductoEntity actualizarProducto(ProductoEntity producto) {
        return productoRepository.actualizarProducto(producto);
    }

    @Override
    public ProductoEntity eliminarProducto(Integer idProducto) {
        return productoRepository.eliminarProducto(idProducto);
    }

    @Override
    public ProductoEntity obtenerProducto(Integer idProducto) {
        return productoRepository.obtenerProducto(idProducto);
    }

    @Override
    public List<ProductoEntity> listarProductos() {
        return productoRepository.listarProductos();
    }
    
}
