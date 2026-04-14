package edu.cibertec.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.repository.ConexionRepository;
import edu.cibertec.repository.PersonaRepository;

@Repository
@DependsOn("conexionRepositoryMysql")
public class PersonaRepositoryImpl  implements PersonaRepository {

    @Autowired
    @Qualifier("conexionRepositoryMysql")
    private ConexionRepository conexion;

    private List<PersonaEntity> listaPersonas;



    public PersonaRepositoryImpl() {
        listaPersonas =  new ArrayList<>();
    }

    @Override
    public void registrarPersona(PersonaEntity persona) {
        conexion.conectar();
        listaPersonas.add(persona);
        System.out.println("Persona registrada: " + persona.getNombre() + " " + persona.getApellido());
        conexion.desconectar();
    }

    @Override
    public void listarPersonas() {
        conexion.conectar();
        System.out.println("Listado de Personas:");
        for (PersonaEntity persona : listaPersonas) {
            System.out.println("ID: " + persona.getIdPersona() + ", Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido() + ", DNI: " + persona.getDni());
        }
        conexion.desconectar();
    }
    
}
