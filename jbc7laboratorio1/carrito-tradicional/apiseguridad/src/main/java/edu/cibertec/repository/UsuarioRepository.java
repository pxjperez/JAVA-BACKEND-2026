package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, Integer> {
    
    public UsuarioEntity findByUser(String user);
}
