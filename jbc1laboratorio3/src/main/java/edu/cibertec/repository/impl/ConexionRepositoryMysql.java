package edu.cibertec.repository.impl;

import edu.cibertec.repository.ConexionRepository;

public class ConexionRepositoryMysql implements ConexionRepository {

    @Override
    public void conectar() {
        System.out.println("Conectando a MySQL...");
    }

    @Override
    public void desconectar() {
        System.out.println("Desconectando de MySQL...");
    }
    
}
