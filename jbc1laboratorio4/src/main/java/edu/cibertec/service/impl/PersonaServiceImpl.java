package edu.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.repository.PersonaRepository;
import edu.cibertec.service.PersonaService;

@Service("personaService")
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
