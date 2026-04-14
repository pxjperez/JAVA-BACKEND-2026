package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cibertec.service.HolaMundoService;

@Configuration
public class AppConfig {

    @Bean
    public HolaMundoService holaMundoService() {
        return new HolaMundoService();
    }

    @Bean
    public HolaMundoService holaMundoServiceConPropiedad() {
        HolaMundoService holaMundoService = new HolaMundoService();
        holaMundoService.setNombre("JUAN CARLOS ANOTACION");
        return holaMundoService;
    }
    
}
