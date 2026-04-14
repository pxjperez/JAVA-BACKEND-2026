package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE user = ?1 AND  password = ?2", nativeQuery = true)
    public UsuarioEntity validarUsuario(String user, String password);

    public UsuarioEntity findByUser(String user);

}
