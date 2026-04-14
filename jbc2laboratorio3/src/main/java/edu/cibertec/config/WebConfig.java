package edu.cibertec.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;


public class WebConfig implements WebApplicationInitializer{

    //Implementando el metodo onStartup que sera el metodo que se ejecutara al iniciar la aplicacion. Aqui se incluye la con configuracion del AppConfig.
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //0.- Nombre de la aplicacion
        servletContext.setAttribute("appName", "Mi Aplicacion");
        //1.- Crear el contexto de la aplicacion web
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //2.- Registrar la clase de configuracion (Donde estan los beans)
        context.register(AppConfig.class);
        context.setServletContext(servletContext);
        //3.- Crear y registrar el DispatcherServlet
        ServletRegistration.Dynamic register = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        //4.- El estado de inicio del servlet
        register.setLoadOnStartup(1);
        //5.- Como se va invocar el servlet o Recurso
        //register.addMapping("*.do"); //Deprecado => Funciona con tomcat inferior al 10 y spring mvc 5
        register.addMapping("/");        
        
    }
    
}
