package edu.cibertec.repository;

import edu.cibertec.dto.CategoriaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoriaRepository {
    public Flux<CategoriaDTO> listarCategorias();
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria);
    public Mono<CategoriaDTO> registrarCategoria(CategoriaDTO categoria);
    public Mono<CategoriaDTO> actualizarCategoria(CategoriaDTO categoria);
    public Mono<Void> eliminarCategoria(Integer idCategoria);
}
