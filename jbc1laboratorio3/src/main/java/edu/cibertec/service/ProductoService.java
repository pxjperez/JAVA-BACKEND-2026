package edu.cibertec.service;

import edu.cibertec.entity.ProductoEntity;

public interface ProductoService {
    public void registrarProducto(ProductoEntity producto);
    public void listarProductos();
}
