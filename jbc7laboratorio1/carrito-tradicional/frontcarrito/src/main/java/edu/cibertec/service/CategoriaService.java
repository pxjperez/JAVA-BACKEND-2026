package edu.cibertec.service;

import edu.cibertec.dto.CategoriaDTO;
import java.util.List;

public interface CategoriaService {
    public List<CategoriaDTO> listarCategorias();
    public CategoriaDTO obtenerCategoria(Integer idCategoria);
    public CategoriaDTO registrarCategoria(CategoriaDTO categoria);
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoria);
    public void eliminarCategoria(Integer idCategoria);
}
