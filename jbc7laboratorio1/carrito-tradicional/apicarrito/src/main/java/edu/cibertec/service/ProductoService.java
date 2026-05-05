package edu.cibertec.service;

import java.util.List;

import edu.cibertec.dto.ProductoDTO;

public interface ProductoService {
    public List<ProductoDTO> listarProductos();
    public ProductoDTO obtenerProducto(Integer idProducto);
    public ProductoDTO registrarProducto(ProductoDTO producto);
    public ProductoDTO actualizarProducto(ProductoDTO producto);
    public void eliminarProducto(Integer idProducto);
}
