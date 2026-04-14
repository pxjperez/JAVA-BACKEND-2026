package edu.cibertec.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.cibertec.config.AppConfig;
import edu.cibertec.service.HolaMundoService;

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

    }
}
