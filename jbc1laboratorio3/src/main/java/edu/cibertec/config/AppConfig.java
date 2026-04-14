package edu.cibertec.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import edu.cibertec.repository.ConexionRepository;
import edu.cibertec.repository.DocumentoRepository;
import edu.cibertec.repository.PersonaRepository;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.repository.impl.ConexionRepositoryMysql;
import edu.cibertec.repository.impl.ConexionRepositoryPostgresSql;
import edu.cibertec.repository.impl.DocumentoRepositoryWord;
import edu.cibertec.repository.impl.PersonaRepositoryImpl;
import edu.cibertec.repository.impl.ProductoRepositoryImpl;
import edu.cibertec.service.DocumentoService;
import edu.cibertec.service.PersonaService;
import edu.cibertec.service.ProductoService;
import edu.cibertec.service.impl.DocumentoServiceImpl;
import edu.cibertec.service.impl.PersonaServiceImpl;
import edu.cibertec.service.impl.ProductoServiceImpl;
import edu.cibertec.utility.HolaMundo;

@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public HolaMundo holaMundo() {
        return new HolaMundo();
    }

    @Bean
    public HolaMundo holaMundoConPropiedad() {
        HolaMundo holaMundo = new HolaMundo();
        holaMundo.setNombre("JUAN CARLOS ANOTACION");
        return holaMundo;
    }

    @Bean
    public ConexionRepository conexionRepositoryPostgresSql() {
        return new ConexionRepositoryPostgresSql();
    }

     @Bean
    public ConexionRepository conexionRepositoryMysql() {
        return new ConexionRepositoryMysql();
    }

    @Bean
    public PersonaRepository personaRepository() {
        return new PersonaRepositoryImpl();
    }

    @Bean
    public PersonaService personaService() {
        return new PersonaServiceImpl();
    }
    
    @Bean
    public ProductoRepository productoRepository() {
        return new ProductoRepositoryImpl();
    }

    @Bean
    public ProductoService productoService() {
        return new ProductoServiceImpl();   
    }

    @Bean
    public DocumentoRepository documentoRepository() {
        return new DocumentoRepositoryWord();
    }

    @Bean
    public DocumentoService documentoService() {
        //return new DocumentoServiceImpl(new DocumentoRepositoryWord());
        return new DocumentoServiceImpl();
    }
}
