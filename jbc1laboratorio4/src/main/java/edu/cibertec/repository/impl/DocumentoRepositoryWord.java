package edu.cibertec.repository.impl;

import org.springframework.stereotype.Repository;

import edu.cibertec.repository.DocumentoRepository;


@Repository
public class DocumentoRepositoryWord implements DocumentoRepository {

    @Override
    public String imprimir() {
        return "Documento en formato WORD";
    }
    
}
