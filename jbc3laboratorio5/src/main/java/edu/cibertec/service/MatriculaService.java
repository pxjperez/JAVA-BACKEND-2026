package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.entity.MatriculaPersonalizadaEntity;

public interface MatriculaService {
    public List<MatriculaEntity> listarMatriculas();
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizada();
     public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizadaNativa();
    public MatriculaEntity obtenerMatricula(Integer idMatricula);
    public MatriculaEntity registrarMatricula(MatriculaEntity matricula);
    public MatriculaEntity actualizarMatricula(MatriculaEntity matricula);
    public MatriculaEntity eliminarMatricula(Integer idMatricula);
}
