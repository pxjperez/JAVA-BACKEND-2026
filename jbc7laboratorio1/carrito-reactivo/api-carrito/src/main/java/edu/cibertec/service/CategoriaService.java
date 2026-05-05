package edu.cibertec.service;

import edu.cibertec.dto.CategoriaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoriaService {
    public Flux<CategoriaDTO> listarCategorias();
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria);
    public Mono<CategoriaDTO> registrarCategoria(CategoriaDTO categoriaDTO);
    public Mono<CategoriaDTO> actualizarCategoria(CategoriaDTO categoriaDTO);
    public Mono<Void> eliminarCategoria(Integer idCategoria);
}
