package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "edu.cibertec")
@EnableWebMvc //Configurar el framework de  Spring MVC
public class AppConfig implements WebMvcConfigurer {
    //Agregando un bean con la configuracion del viewResolver
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");//carpeta donde se encuentran las vistas
        resolver.setSuffix(".jsp");//extension de las vistas
        return resolver;
    }

    //Bean para la carga de archivos estáticos (CSS, JS, IMAGENES)
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    //Mapear la ruta de archivos estaticos del aplicativo
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**") //Ruta publica
                .addResourceLocations("/static/"); //Ruta interna donde se encuentran los archivos
    }

}
