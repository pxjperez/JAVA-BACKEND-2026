package edu.cibertec.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.repository.ConexionRepository;
import edu.cibertec.repository.ProductoRepository;

@Repository
@DependsOn("conexionRepositoryPostgresSql")
public class ProductoRepositoryImpl implements ProductoRepository {

    @Autowired
    @Qualifier("conexionRepositoryPostgresSql")
    private ConexionRepository conexion;

    private List<ProductoEntity> listaProductos;

    public ProductoRepositoryImpl() {
        listaProductos =  new ArrayList<>();
    }

    @Override
    public void registrarProducto(ProductoEntity producto) {
        conexion.conectar();
        listaProductos.add(producto);
        System.out.println("Producto registrado: " + producto.getNombre());
        conexion.desconectar();
    }

    @Override
    public void listarProductos() {
        conexion.conectar();
        System.out.println("Listado de Productos:");
        for (ProductoEntity producto : listaProductos) {
            System.out.println("ID: " + producto.getIdProducto() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
        conexion.desconectar();
    }
    
}
