package edu.cibertec.service.impl;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.service.CategoriaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    public Flux<CategoriaDTO> listarCategorias() {
        return categoriaRepository.listarCategorias();
    }

    @Override
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria) {
        return categoriaRepository.obtenerCategoria(idCategoria);
    }

    @Override
    public Mono<CategoriaDTO> registrarCategoria(CategoriaDTO categoria) {
        return categoriaRepository.registrarCategoria(categoria);
    }

    @Override
    public Mono<CategoriaDTO> actualizarCategoria(CategoriaDTO categoria) {
        return categoriaRepository.actualizarCategoria(categoria);
    }

    @Override
    public Mono<Void> eliminarCategoria(Integer idCategoria) {
        return categoriaRepository.eliminarCategoria(idCategoria);
    }
}
