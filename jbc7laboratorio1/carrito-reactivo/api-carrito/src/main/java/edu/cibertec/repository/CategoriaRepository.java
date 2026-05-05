package edu.cibertec.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import edu.cibertec.entity.CategoriaEntity;

public interface CategoriaRepository extends ReactiveCrudRepository<CategoriaEntity, Integer>{
    
}
