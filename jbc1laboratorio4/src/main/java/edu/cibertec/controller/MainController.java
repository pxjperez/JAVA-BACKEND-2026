package edu.cibertec.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.cibertec.config.AppConfig;
import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.service.DocumentoService;
import edu.cibertec.service.PersonaService;
import edu.cibertec.service.ProductoService;
import edu.cibertec.utility.HolaMundo;

@Controller
public class MainController {
    public static void main(String[] args) {
        System.out.println("Configuracion por Anotaciones - Spring Framework");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("----- Saludo sin propiedad -----");
        //HolaMundoService holaMundoServicePorClase = context.getBean(HolaMundoService.class);
        //System.out.println(holaMundoServicePorClase.saludar());
        //HolaMundo holaMundoPorNombre = (HolaMundo) context.getBean("holaMundo");
        //System.out.println(holaMundoPorNombre.saludar());

        System.out.println("----- Saludo con propiedad -----");
        HolaMundo holaMundoConPropiedad = (HolaMundo) context.getBean("holaMundoConPropiedad");
        System.out.println(holaMundoConPropiedad.saludar());

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
        DocumentoService documentoService = (DocumentoService) context.getBean("documentoServiceImpl");
        documentoService.imprimirDocumento();

        System.out.println("Configuracion por XML - Spring Framework");
        //1.-Llamar al contexto de XML
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("AppConfig.xml");
        System.out.println("----- Saludo sin propiedad -----");
        //2.- Invocamos las instacions de los beans definidos en el XML
        HolaMundo holaMundoXML = (HolaMundo) contextXML.getBean("holaMundo");
        System.out.println(holaMundoXML.saludar());
        System.out.println("----- Saludo con propiedad -----");
        HolaMundo holaMundoConPropiedadXML = (HolaMundo) contextXML.getBean("holaMundoConPropiedad");
        System.out.println(holaMundoConPropiedadXML.saludar());
        System.out.println("----- SERVICIO DOCUMENTO -----");
        DocumentoService documentoServiceXML = (DocumentoService) contextXML.getBean("documentoServiceImpl");
        documentoServiceXML.imprimirDocumento();

        //Lista de beans por defecto con Anotaciones
        System.out.println("Lista de Beans registrados en el contexto Anotaciones:");   
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);  
        } 

        //Lista de beans por defecto XML
        System.out.println("Lista de Beans registrados en el contexto XML:");   
        String[] beanNamesXml = contextXML.getBeanDefinitionNames();
        for(String beanName : beanNamesXml) {
            System.out.println(beanName);  
        }

        //Probando el scope de los beans 
        System.out.println("----- PROBANDO SCOPE DE BEANS DESDE EL APP CONFIG -----");
        HolaMundo hola1 = (HolaMundo) context.getBean("holaMundo");
        HolaMundo hola2 = (HolaMundo) context.getBean("holaMundo");
        System.out.println(hola1.saludar());
        System.out.println(hola2.saludar());
        hola1.setNombre("JUAN PEREZ");
        System.out.println(hola1.saludar());
        System.out.println(hola2.saludar());
        ((AnnotationConfigApplicationContext) context).close();
        //Probando el scope de los beans 
        System.out.println("----- PROBANDO SCOPE DE BEANS DESDE EL APP CONFIG XML -----");
        HolaMundo hola3 = (HolaMundo) contextXML.getBean("holaMundo");
        HolaMundo hola4 = (HolaMundo) contextXML.getBean("holaMundo");
        System.out.println(hola3.saludar());
        System.out.println(hola4.saludar());
        hola3.setNombre("JUAN DIAZ");
        System.out.println(hola3.saludar());
        System.out.println(hola4.saludar());
        //Destruir beans y liberar recursos
        ((ClassPathXmlApplicationContext) contextXML).close();
    }
}
