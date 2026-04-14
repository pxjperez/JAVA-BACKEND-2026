package edu.cibertec.repository.impl;

import org.springframework.stereotype.Repository;

import edu.cibertec.repository.ConexionRepository;

@Repository
public class ConexionRepositoryMysql implements ConexionRepository {
    @Override
    public void conectar() {
        System.out.println("Conectando a la base de datos MySQL...");
    }

    @Override
    public void desconectar() {
        System.out.println("Desconectando de la base de datos MySQL...");
    }
    
}
