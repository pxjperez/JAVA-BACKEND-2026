package edu.cibertec.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.repository.ProductoRepository;

@Repository
public class ProductoRepositoryImpl  implements ProductoRepository {

    private List<ProductoEntity> productos;

    @Autowired
    private ConexionRepositoryMysql conexion;

    

    public ProductoRepositoryImpl() {
        this.productos = new ArrayList<>();
    }

    @Override
    public ProductoEntity registrarProducto(ProductoEntity producto) {
        conexion.conectar();
        productos.add(producto);
        conexion.desconectar();
        return producto;
    }

    @Override
    public ProductoEntity actualizarProducto(ProductoEntity producto) {
        conexion.conectar();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto().equals(producto.getIdProducto())) {
                productos.set(i, producto);
                conexion.desconectar();
            }
        }
        conexion.desconectar();
        return producto;
    }

    @Override
    public ProductoEntity eliminarProducto(Integer idProducto) {
        conexion.conectar();
        ProductoEntity productoEliminado =  obtenerProducto(idProducto);
        productoEliminado.setEstado(false);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto().equals(productoEliminado.getIdProducto())) {
                productos.set(i, productoEliminado);
                conexion.desconectar();
            }
        }
        conexion.desconectar();
        return productoEliminado;
    }

    @Override
    public ProductoEntity obtenerProducto(Integer idProducto) {
        conexion.conectar();
        ProductoEntity productoEncontrado = null;
        for (ProductoEntity producto : productos) {
            if (producto.getIdProducto().equals(idProducto)) {
                productoEncontrado = producto;
                break;
            }
        }
        conexion.desconectar();
        return productoEncontrado;
    }

    @Override
    public List<ProductoEntity> listarProductos() {
        conexion.conectar();
        conexion.desconectar();
        return productos;
    }
    
}
