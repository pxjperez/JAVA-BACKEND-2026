package edu.cibertec.repository.impl;

import edu.cibertec.repository.DocumentoRepository;

public class DocumentoRepositoryWord implements DocumentoRepository {

    @Override
    public String imprimir() {
        return "Documento en formato WORD";
    }
    
}
