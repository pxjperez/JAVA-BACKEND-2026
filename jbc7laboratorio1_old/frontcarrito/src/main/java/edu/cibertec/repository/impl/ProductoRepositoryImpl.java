package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

     @Value("${url.api.productos}")
    private String urlApiProductos;
    private final RestTemplate restTemplate;
 
    @Override
    public List<ProductoDTO> listarProductos() {
        ResponseEntity<List<ProductoDTO>> response = restTemplate.exchange(
                urlApiProductos,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductoDTO>>() {
                });
        return response.getBody();
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
                urlApiProductos + "/" + idProducto,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ProductoDTO>() {
                });
        return response.getBody();
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
                urlApiProductos,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<ProductoDTO>() {
                });
        return response.getBody();
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) {
        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
                urlApiProductos + "/" + producto.getIdProducto(),
                HttpMethod.PUT,
                null,
                new ParameterizedTypeReference<ProductoDTO>() {
                });
        return response.getBody();
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        ResponseEntity<Void> response = restTemplate.exchange(
                urlApiProductos + "/" + idProducto,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Void>() {
                });
    }
    
}
