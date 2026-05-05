package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.repository.mapper.ProductoMapper;
import edu.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private ProductoMapper mapper = Mappers.getMapper(ProductoMapper.class);

    @Override
    public List<ProductoDTO> listarProductos() {
        return mapper.convertirListaEntityToDto(productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return mapper.convertirEntityToDto(productoRepository.findById(idProducto).orElse(null));
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        return mapper.convertirEntityToDto(productoRepository.save(mapper.convertirDtoToEntity(producto)));
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) {
        return mapper.convertirEntityToDto(productoRepository.save(mapper.convertirDtoToEntity(producto)));
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }
    
}
