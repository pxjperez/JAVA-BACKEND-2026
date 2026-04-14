package edu.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query(value = "SELECT * FROM usuario  WHERE estado = 1", nativeQuery = true)
    public List<UsuarioEntity> listaUsuarios();

    @Query(value = "SELECT * FROM usuario  WHERE estado = 1 AND idusuario=?1", nativeQuery = true)
    public UsuarioEntity obtenerUsuario(Integer idUsuario);

    @Query(value = "SELECT * FROM usuario  WHERE estado = 1 AND user=?1 AND password=?2", nativeQuery = true)
    public UsuarioEntity validarUsuario(String user, String password);

}
