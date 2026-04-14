package edu.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;


public class ProductoServiceImpl  implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public void registrarProducto(ProductoEntity producto) {
        productoRepository.registrarProducto(producto);
    }

    @Override
    public void listarProductos() {
        productoRepository.listarProductos();
    }
    
}
