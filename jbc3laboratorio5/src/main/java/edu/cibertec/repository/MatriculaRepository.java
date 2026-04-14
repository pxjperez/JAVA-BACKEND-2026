package edu.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.entity.MatriculaPersonalizadaEntity;

import org.springframework.data.jpa.repository.Query;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer> {
    //Se coloca la ruta completa de la clase MatriculaPersonalizadaEntity
    @Query("SELECT new edu.cibertec.entity.MatriculaPersonalizadaEntity(m.idMatricula, u.nombreCompleto, c.nombreCurso, m.estado) "
         + "FROM MatriculaEntity m "
         + "JOIN m.usuario u "
         + "JOIN m.curso c ")
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizada();

    @Query(value =  "SELECT m.idmatricula AS idMatricula, u.nombreapellido AS nombreUsuario, c.nomcurso AS nombreCurso, m.estado AS estado "
                  + "FROM matricula m "
                  + "JOIN usuario u ON m.idusuario = u.idusuario "
                  + "JOIN curso c ON m.idcurso = c.idcurso", nativeQuery = true)
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizadaNativa();

}
