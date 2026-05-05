package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {


    @Value("${url.api.categorias}")
    private String urlApiCategorias;
    private final RestTemplate restTemplate;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        ResponseEntity<List<CategoriaDTO>> response = restTemplate.exchange(
                urlApiCategorias,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CategoriaDTO>>() {
                });
        return response.getBody();
    }

    @Override
    public CategoriaDTO obtenerCategoria(Integer idCategoria) {
        ResponseEntity<CategoriaDTO> response = restTemplate.exchange(
                urlApiCategorias + "/" + idCategoria,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<CategoriaDTO>() {
                });
        return response.getBody();
    }

    @Override
    public CategoriaDTO registrarCategoria(CategoriaDTO categoria) {
        ResponseEntity<CategoriaDTO> response = restTemplate.exchange(
                urlApiCategorias,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<CategoriaDTO>() {
                });
        return response.getBody();
    }

    @Override
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoria) {
        ResponseEntity<CategoriaDTO> response = restTemplate.exchange(
                urlApiCategorias + "/" + categoria.getIdCategoria(),
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<CategoriaDTO>() {
                });
        return response.getBody();
    }

    @Override
    public void eliminarCategoria(Integer idCategoria) {
        ResponseEntity<Void> response = restTemplate.exchange(
                urlApiCategorias + "/" + idCategoria,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Void>() {
                });
    }
    
}
