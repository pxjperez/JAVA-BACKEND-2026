package edu.cibertec.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {


    @Value("${url.api.categorias}")
    private String urlApiCategorias;

    private static final String ID_PATH = "/{idCategoria}";

    @Override
    public Flux<CategoriaDTO> listarCategorias() {
        return WebClient.create(urlApiCategorias).get()
                                                 .retrieve()
                                                 .bodyToFlux(CategoriaDTO.class);
    }

    @Override
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria) {
        return WebClient.create(urlApiCategorias).get()
                .uri(ID_PATH, idCategoria)
                .retrieve()
                .bodyToMono(CategoriaDTO.class);
    }

    @Override
    public Mono<CategoriaDTO> registrarCategoria(CategoriaDTO categoria) {
        return WebClient.create(urlApiCategorias).post()
                .bodyValue(categoria)
                .retrieve()
                .bodyToMono(CategoriaDTO.class);
    }

    @Override
    public Mono<CategoriaDTO> actualizarCategoria(CategoriaDTO categoria) {
        return WebClient.create(urlApiCategorias).put()
                .uri(ID_PATH, categoria.getIdCategoria())
                .bodyValue(categoria)
                .retrieve()
                .bodyToMono(CategoriaDTO.class);
    }

    @Override
    public Mono<Void> eliminarCategoria(Integer idCategoria) {
        return WebClient.create(urlApiCategorias).delete()
                .uri(ID_PATH, idCategoria)
                .retrieve()
                .bodyToMono(Void.class);
    }

}

