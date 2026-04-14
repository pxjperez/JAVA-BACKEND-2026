package edu.cibertec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.cibertec.entity.CursoEntity;
import jakarta.data.repository.Param;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
    //*Consultas usando DSL
    //**Consulta por nombre de curso
    public List<CursoEntity> findByNombreCursoContainingIgnoreCase(String nombreCurso);
    //**Consulta por nombre de curso y alumnos minimo
    public List<CursoEntity> findByNombreCursoContainingIgnoreCaseAndAlumnosMinimo(String nombreCurso, Integer alumnosMinimo);
    
    //*Consultas usando JPQL
    //**Consulta por estado
    @Query("SELECT c FROM CursoEntity c WHERE c.estado=?1")
    public List<CursoEntity> consultarPorEstado(Integer estado);
    
    //**Consulta por fecha
    @Query("SELECT c FROM CursoEntity c WHERE c.fechaInicio>=:fecha")
    public List<CursoEntity> consultarPorFecha(@Param("fecha")Date fecha);
    
    //*Consultas usando SQL
    @Query(value = "SELECT * FROM curso WHERE (alumnosmin-alumnosact)<=:cantidad",nativeQuery = true)
    public List<CursoEntity> consultarFaltantes(@Param("cantidad")Integer cantidad);
    //*Consultas a procedimientos almacenados
    @Query(value = "CALL Curso_Por_Nombre(?1)",nativeQuery = true)
    public List<CursoEntity> consultaPorNombre(String nombre);
    
    //*Consultas nombradas
    public List<CursoEntity> abiertoIncompleto();
    public List<CursoEntity> abiertoIncompletoNativo();
}
