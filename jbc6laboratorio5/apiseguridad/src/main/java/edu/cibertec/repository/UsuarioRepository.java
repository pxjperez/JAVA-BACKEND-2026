package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import edu.cibertec.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE user = ?1", nativeQuery = true)
    public UsuarioEntity obtenerUsuario(String user);

}