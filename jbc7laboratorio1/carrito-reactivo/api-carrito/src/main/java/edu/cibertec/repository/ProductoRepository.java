package edu.cibertec.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import edu.cibertec.entity.ProductoEntity;

public interface ProductoRepository extends ReactiveCrudRepository<ProductoEntity, Integer>{
    
}
