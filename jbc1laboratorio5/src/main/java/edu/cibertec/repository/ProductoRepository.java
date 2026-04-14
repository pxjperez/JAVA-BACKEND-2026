package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.entity.ProductoEntity;

public interface ProductoRepository {
    public ProductoEntity registrarProducto(ProductoEntity producto);
    public ProductoEntity actualizarProducto(ProductoEntity producto);
    public ProductoEntity eliminarProducto(Integer idProducto);
    public ProductoEntity obtenerProducto(Integer idProducto);
    public List<ProductoEntity> listarProductos();
}
