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
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration //Traiga todas las configuraciones de Spring
@ComponentScan(basePackages = "edu.cibertec") // Escanear los componentes en el paquete edu.cibertec
@EnableWebMvc //Configurar el framework de  Spring MVC
public class AppConfig implements WebMvcConfigurer {
    //Agregando un bean con la configuracion del viewResolver
    //@Bean
    //public InternalResourceViewResolver internalResourceViewResolver() {
    //    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    //    resolver.setPrefix("/view/");//carpeta donde se encuentran las vistas
    //    resolver.setSuffix(".jsp");//extension de las vistas
    //    return resolver;
    //}

    //Inicio configuracion de thymeleaf
    //Configuracion del template resolver de thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/view/"); // Carpeta donde se encuentran las vistas
        templateResolver.setSuffix(".html"); // Extension de las vistas
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    //Configuracion del Template Engine de thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    //Configuraicon de View Resolver de thymeleaf
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
    //Fin configuracion de thymeleaf

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
