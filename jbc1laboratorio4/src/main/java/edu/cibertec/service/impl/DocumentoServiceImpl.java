package edu.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.repository.DocumentoRepository;
import edu.cibertec.service.DocumentoService;

@Service
public class DocumentoServiceImpl implements DocumentoService {
    
    @Autowired
    private DocumentoRepository documentoRepository;

    public DocumentoServiceImpl() {
    }

    public DocumentoServiceImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public void imprimirDocumento() {
        String contenido = documentoRepository.imprimir();
        System.out.println("Imprimiendo: " + contenido);
    }

    public DocumentoRepository getDocumentoRepository() {
        return documentoRepository;
    }

    public void setDocumentoRepository(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }
    
}

    