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
         + "JOIN m.curso c ") //En una consulta jpql no se necesita el mapeo de resultados, se puede usar el constructor directamente
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizada();

    @Query(value =  "SELECT m.idmatricula AS idMatricula, u.nombreapellido AS nombreUsuario, c.nomcurso AS nombreCurso, m.estado AS estado "
                  + "FROM matricula m "
                  + "JOIN usuario u ON m.idusuario = u.idusuario "
                  + "JOIN curso c ON m.idcurso = c.idcurso", nativeQuery = true)//En una consulta nativa se necesita el mapeo de resultados, se debe usar el nombre del mapeo definido en la clase MatriculaPersonalizadaEntity
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizadaNativa();

}
