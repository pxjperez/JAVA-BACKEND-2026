package edu.cibertec.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;


public class WebConfig implements WebApplicationInitializer{

    //Implementando el metodo onStartup que sera el metodo que se ejecutara al iniciar la aplicacion. Aqui se incluye la con configuracion del AppConfig.
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //0.- Variables de contexto de la aplicacion web
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
        
        //6.- Configuración multipart para carga de archivos
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
            System.getProperty("java.io.tmpdir"), // Directorio temporal
            50 * 1024 * 1024,  // Tamaño máximo por archivo (50MB)
            100 * 1024 * 1024, // Tamaño máximo total de la request (100MB)
            1024 * 1024        // Umbral de memoria (1MB)
        );
        register.setMultipartConfig(multipartConfig);
        
    }

    //String boot
    //@SpringBootApplication //Trae todas las configuraciones de Spring
    
}
