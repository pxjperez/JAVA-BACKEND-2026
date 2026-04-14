package edu.cibertec.service;

import edu.cibertec.entity.PersonaEntity;

public interface PersonaService {
    public void registrarPersona(PersonaEntity persona);
    public void listarPersonas();
}
