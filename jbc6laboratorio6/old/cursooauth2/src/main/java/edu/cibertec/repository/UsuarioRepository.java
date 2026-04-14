package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Integer> {
    public UsuarioEntity findByUser(String user);
    public UsuarioEntity findByUserAndPassword(String user, String password);
}
