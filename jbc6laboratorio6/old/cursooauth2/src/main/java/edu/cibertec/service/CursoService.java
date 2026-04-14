package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.CursoEntity;

public interface CursoService {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
}
