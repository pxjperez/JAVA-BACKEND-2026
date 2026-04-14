package edu.cibertec.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import edu.cibertec.config.AppConfig;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.service.ProductoService;

@Controller
public class Main {


    public static void main(String[] args) {
        System.out.println("Carga exitosa de Spring Framework");
        ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
        ProductoService productoService = context.getBean(ProductoService.class);
        System.out.println("REGISTRAR PRODUCTOS");
        productoService.registrarProducto(new ProductoEntity(1, "MANZANA", 2.5, true));
        productoService.registrarProducto(new ProductoEntity(2, "BANANO", 1.3, true));
        System.out.println("LISTAR PRODUCTOS");
        for (ProductoEntity producto : productoService.listarProductos()) {
            System.out.println(producto);
        }
        
    }
}