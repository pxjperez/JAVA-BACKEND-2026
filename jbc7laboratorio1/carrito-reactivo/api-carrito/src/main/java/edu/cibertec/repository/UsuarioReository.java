package edu.cibertec.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioReository extends ReactiveCrudRepository<UsuarioEntity, Integer>{
    
}
