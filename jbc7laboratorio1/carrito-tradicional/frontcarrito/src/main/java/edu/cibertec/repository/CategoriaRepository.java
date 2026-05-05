package edu.cibertec.repository;

import java.util.List;
import edu.cibertec.dto.CategoriaDTO;

public interface CategoriaRepository {
    public List<CategoriaDTO> listarCategorias();
    public CategoriaDTO obtenerCategoria(Integer idCategoria);
    public CategoriaDTO registrarCategoria(CategoriaDTO categoria);
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoria);
    public void eliminarCategoria(Integer idCategoria);
}
