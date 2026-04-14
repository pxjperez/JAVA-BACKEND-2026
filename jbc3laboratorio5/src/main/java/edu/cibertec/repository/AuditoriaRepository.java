package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.AuditoriaEntity;

public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity, Integer> {
    
}
