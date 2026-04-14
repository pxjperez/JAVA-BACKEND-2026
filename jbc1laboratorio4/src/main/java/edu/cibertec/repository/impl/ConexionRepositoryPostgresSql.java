package edu.cibertec.repository.impl;

import org.springframework.stereotype.Repository;

import edu.cibertec.repository.ConexionRepository;

@Repository
public class ConexionRepositoryPostgresSql implements ConexionRepository {

    @Override
    public void conectar() {
        System.out.println("Conectando a PostgreSQL...");
    }

    @Override
    public void desconectar() {
        System.out.println("Desconectando de PostgreSQL...");
    }
    
}
