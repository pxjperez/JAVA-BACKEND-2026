package edu.cibertec.service;

import java.util.Date;
import java.util.List;

import edu.cibertec.entity.CursoEntity;

public interface CursoService {
    public List<CursoEntity> listarCursosPorNombreCurso(String nombreCurso);
    public List<CursoEntity> listarCursosPorNombreCursoAndAlumnosMinimo(String nombreCurso, Integer alumnosMinimo);
    public List<CursoEntity> consultarPorEstado(Integer estado);
    public List<CursoEntity> abiertoIncompleto();
    public List<CursoEntity> abiertoIncompletoNativo();
    public List<CursoEntity> consultaPorFecha(Date fecha);
    public List<CursoEntity> consultaFaltantes(Integer cantidad);
    public List<CursoEntity> consultaPorNombre(String nombre);
    public CursoEntity obtenerCurso(Integer idCurso);
    public CursoEntity registrarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public CursoEntity eliminarCurso(Integer idCurso);
}
