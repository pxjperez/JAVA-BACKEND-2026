package edu.cibertec.service.impl;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.service.CategoriaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.listarCategorias();
    }

    @Override
    public CategoriaDTO obtenerCategoria(Integer idCategoria) {
        return categoriaRepository.obtenerCategoria(idCategoria);
    }

    @Override
    public CategoriaDTO registrarCategoria(CategoriaDTO categoria) {
        return categoriaRepository.registrarCategoria(categoria);
    }

    @Override
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoria) {
        return categoriaRepository.actualizarCategoria(categoria);
    }

    @Override
    public void eliminarCategoria(Integer idCategoria) {
        categoriaRepository.eliminarCategoria(idCategoria);
    }
}
