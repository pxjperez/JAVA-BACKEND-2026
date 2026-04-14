package edu.cibertec.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    //Ejemplo con una consula nativa
    @Query(value = "SELECT * FROM usuario WHERE user=?1 AND password=?2",nativeQuery = true)
    public UsuarioEntity validarUsuario(String user, String password);

    //Ejemplo con una consula nativa
    @Query(value = "SELECT * FROM usuario WHERE estado=1",nativeQuery = true) //Recomiendo usar consultas nativas
    public List<UsuarioEntity> listaUsuario();

    //Ejemplo con una consulta nativa
    @Query(value = "SELECT * FROM usuario WHERE estado=1 AND user LIKE CONCAT('%',:user,'%')",nativeQuery = true)
    public List<UsuarioEntity> buscarUsuario(@Param("user") String user);

    //Ejemplo con una consulta JPQL
     @Query("SELECT u FROM UsuarioEntity u WHERE u.user like %?1% AND u.estado=true")
     public List<UsuarioEntity> listarUsuarios(String user);

    //Ejemplo con una consulta DSL
    //findByUserAndPassword => Internamente lo va a convertir en una una consutal SQL
     public UsuarioEntity findByUserAndPassword(String user, String password); //findByUserAndPassword => select * from usuario where user=? and password=?

     //Ejemplo de paginaion con consulta dsl
     public List<UsuarioEntity> findByEstadoTrueAndUserContaining(String user, Pageable pageable); 
     public List<UsuarioEntity> findByEstadoTrueAndUserContaining(String user); 
  }
