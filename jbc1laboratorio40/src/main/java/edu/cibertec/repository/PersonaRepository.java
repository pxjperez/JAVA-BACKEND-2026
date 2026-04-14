package edu.cibertec.repository;

import edu.cibertec.entity.PersonaEntity;

public interface PersonaRepository {
    public void registrarPersona(PersonaEntity persona);
    public void listarPersonas();
}
