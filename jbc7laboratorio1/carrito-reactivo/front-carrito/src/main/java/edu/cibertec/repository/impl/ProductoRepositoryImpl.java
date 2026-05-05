package edu.cibertec.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class ProductoRepositoryImpl implements ProductoRepository {



    @Value("${url.api.productos}")
    private String urlApiProductos;

    private static final String ID_PATH = "/{idProducto}";
 
    @Override
    public Flux<ProductoDTO> listarProductos() {
        Flux<ProductoDTO> bloque1 = WebClient.create(urlApiProductos).get().retrieve().bodyToFlux(ProductoDTO.class);
        Flux<ProductoDTO> bloque2 = WebClient.create(urlApiProductos).get().retrieve().bodyToFlux(ProductoDTO.class);
        Flux<ProductoDTO> bloque3 = WebClient.create(urlApiProductos).get().retrieve().bodyToFlux(ProductoDTO.class);
        return Flux.merge(bloque1, bloque2, bloque3);
    }

    @Override
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto) {
        return WebClient.create(urlApiProductos).get()
                .uri(ID_PATH, idProducto)
                .retrieve()
                .bodyToMono(ProductoDTO.class);
    }

    @Override
    public Mono<ProductoDTO> registrarProducto(ProductoDTO producto) {
        return WebClient.create(urlApiProductos).post()
                .bodyValue(producto)
                .retrieve()
                .bodyToMono(ProductoDTO.class);
    }
    @Override
    public Mono<ProductoDTO> actualizarProducto(ProductoDTO producto) {
        return WebClient.create(urlApiProductos).put()
                .uri(ID_PATH, producto.getIdProducto())
                .bodyValue(producto)
                .retrieve()
                .bodyToMono(ProductoDTO.class);
    }
        
    @Override
    public Mono<Void> eliminarProducto(Integer idProducto) {
        return WebClient.create(urlApiProductos).delete()
                .uri(ID_PATH, idProducto)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
