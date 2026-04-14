package edu.cibertec.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.cibertec.config.AppConfig;
import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.service.DocumentoService;
import edu.cibertec.service.HolaMundoService;
import edu.cibertec.service.PersonaService;
import edu.cibertec.service.ProductoService;

public class MainController {
    public static void main(String[] args) {
        System.out.println("Configuracion por Anotaciones - Spring Framework");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("----- Saludo sin propiedad -----");
        //HolaMundoService holaMundoServicePorClase = context.getBean(HolaMundoService.class);
        //System.out.println(holaMundoServicePorClase.saludar());
        HolaMundoService holaMundoServicePorNombre = (HolaMundoService) context.getBean("holaMundoService");
        System.out.println(holaMundoServicePorNombre.saludar());

        System.out.println("----- Saludo con propiedad -----");
        HolaMundoService holaMundoServiceConPropiedad = (HolaMundoService) context.getBean("holaMundoServiceConPropiedad");
        System.out.println(holaMundoServiceConPropiedad.saludar());

        System.out.println("PRUEBA DE SERVICIO Y REPOSITORIO - ANOTACIONES (INYECCION POR PROPIEAD)");
        System.out.println("----- SERVICIO PERSONA -----");
        PersonaService personaService = (PersonaService) context.getBean("personaService");
        personaService.registrarPersona(new PersonaEntity(1, "JUAN CARLOS", "PEREZ GIL", "71583403"));
        personaService.registrarPersona(new PersonaEntity(2, "MARIA", "LOPEZ SANCHEZ", "47851236"));
        personaService.listarPersonas();

        System.out.println("----- SERVICIO PRODUCTO -----");
        ProductoService productoService = (ProductoService) context.getBean("productoService");
        productoService.registrarProducto(new ProductoEntity(1, "MANZANA", 8.9));
        productoService.registrarProducto(new ProductoEntity(2, "PAPAYA", 12.5));
        productoService.listarProductos();
        
        System.out.println("----- SERVICIO DOCUMENTO -----");
        DocumentoService documentoService = (DocumentoService) context.getBean("documentoService");
        documentoService.imprimirDocumento();

        System.out.println("Configuracion por XML - Spring Framework");
        //1.-Llamar al contexto de XML
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("AppConfig.xml");
        System.out.println("----- Saludo sin propiedad -----");
        //2.- Invocamos las instacions de los beans definidos en el XML
        HolaMundoService holaMundoServiceXML = (HolaMundoService) contextXML.getBean("holaMundoService");
        System.out.println(holaMundoServiceXML.saludar());
        System.out.println("----- Saludo con propiedad -----");
        HolaMundoService holaMundoServiceConPropiedadXML = (HolaMundoService) contextXML.getBean("holaMundoServiceConPropiedad");
        System.out.println(holaMundoServiceConPropiedadXML.saludar());
        System.out.println("----- SERVICIO DOCUMENTO -----");
        DocumentoService documentoServiceXML = (DocumentoService) contextXML.getBean("documentoService");
        documentoServiceXML.imprimirDocumento();

    }
}
