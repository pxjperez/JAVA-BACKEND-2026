package edu.cibertec.service;

import edu.cibertec.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {
    public List<ProductoDTO> listarProductos();
    public ProductoDTO obtenerProducto(Integer idProducto);
    public ProductoDTO registrarProducto(ProductoDTO producto);
    public ProductoDTO actualizarProducto(ProductoDTO producto);
    public void eliminarProducto(Integer idProducto);
}
