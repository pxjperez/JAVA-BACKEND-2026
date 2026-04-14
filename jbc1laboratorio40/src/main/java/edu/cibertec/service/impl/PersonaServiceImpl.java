package edu.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.repository.PersonaRepository;
import edu.cibertec.service.PersonaService;

public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void registrarPersona(PersonaEntity persona) {
        personaRepository.registrarPersona(persona);
    }

    @Override
    public void listarPersonas() {
        personaRepository.listarPersonas();
    }
    
}
