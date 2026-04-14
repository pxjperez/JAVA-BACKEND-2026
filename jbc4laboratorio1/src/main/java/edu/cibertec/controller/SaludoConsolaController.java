package edu.cibertec.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class SaludoConsolaController implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola Mundo desde Spring Boot en la Consola");
    }

    @Bean
    public CommandLineRunner mostrarMensajeInicio(ApplicationContext context) {
        return args -> {
            System.out.println("Bienvenido a la aplicación Spring Boot");
            for (String arg : context.getBeanDefinitionNames()) {
                System.out.println("BEANS: " + arg);
            }
        };
    }
    
}
