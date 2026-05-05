package edu.cibertec.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.entity.ProductoEntity;
import edu.cibertec.mapper.CategoriaMapper;
import edu.cibertec.mapper.ProductoMapper;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PorductoServiceImpl  implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoMapper mapperProducto = Mappers.getMapper(ProductoMapper.class);
    private final CategoriaMapper mapperCategoria = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public Flux<ProductoDTO> listarProductos() {
        return productoRepository.findAll()
                .flatMap(producto-> categoriaRepository.findById(producto.getIdCategoria())
                        .map(categoria -> {
                            ProductoDTO productoDTO = mapperProducto.convertirEntityToDto(producto);
                            productoDTO.setCategoria(mapperCategoria.convertirEntityToDto(categoria));
                            return productoDTO;
                        }));
    }

    @Override
    public Mono<ProductoDTO> obtenerProducto(Integer idProducto) {
        return productoRepository.findById(idProducto)
                .flatMap(producto-> categoriaRepository.findById(producto.getIdCategoria())
                        .map(categoria -> {
                            ProductoDTO productoDTO = mapperProducto.convertirEntityToDto(producto);
                            productoDTO.setCategoria(mapperCategoria.convertirEntityToDto(categoria));
                            return productoDTO;
                        }));
    }

    @Override
    public Mono<ProductoDTO> registrarProducto(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = mapperProducto.convertirDtoToEntity(productoDTO);
        return productoRepository.save(productoEntity) 
            .flatMap(producto ->
                categoriaRepository.findById(producto.getIdCategoria()) // acceso correcto
                    .map(categoria -> {
                        ProductoDTO dto = mapperProducto.convertirEntityToDto(producto);
                        dto.setCategoria(mapperCategoria.convertirEntityToDto(categoria));
                        return dto;
                    })
            );
    }

    @Override
    public Mono<ProductoDTO> actualizarProducto(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = mapperProducto.convertirDtoToEntity(productoDTO);
        return productoRepository.findById(productoEntity.getIdProducto())
            .flatMap(existingProducto -> 
                productoRepository.save(productoEntity)
                    .flatMap(producto ->
                        categoriaRepository.findById(producto.getIdCategoria())
                            .map(categoria -> {
                                ProductoDTO dto = mapperProducto.convertirEntityToDto(producto);
                                dto.setCategoria(mapperCategoria.convertirEntityToDto(categoria));
                                return dto;
                            })
                    )
            );
    }

    @Override
    public Mono<Void> eliminarProducto(Integer idProducto) {
        return productoRepository.deleteById(idProducto);
    }
    
}
