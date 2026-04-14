package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "edu.cibertec")
@EnableWebMvc //Configurar el framework de  Spring MVC
public class AppConfig {
    //Agregando un bean con la configuracion del viewResolver
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");//carpeta donde se encuentran las vistas
        resolver.setSuffix(".jsp");//extension de las vistas
        return resolver;
    }
}
