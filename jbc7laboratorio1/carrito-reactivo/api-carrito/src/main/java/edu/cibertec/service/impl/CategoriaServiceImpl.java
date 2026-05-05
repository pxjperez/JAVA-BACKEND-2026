package edu.cibertec.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.entity.CategoriaEntity;
import edu.cibertec.mapper.CategoriaMapper;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private CategoriaMapper mapper = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public Flux<CategoriaDTO> listarCategorias() {
    
        return categoriaRepository.findAll()
                //.map(mapper::convertirEntityToDto);// Mas eficiente
                .map(c->{
                  return mapper.convertirEntityToDto(c);
                });
    }

    @Override
    public Mono<CategoriaDTO> obtenerCategoria(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria)
                .map(mapper::convertirEntityToDto);
    }

    @Override
    public Mono<CategoriaDTO> registrarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = mapper.convertirDtoToEntity(categoriaDTO);
        return categoriaRepository.save(categoriaEntity)
                .map(mapper::convertirEntityToDto);
    }

    @Override
    public Mono<CategoriaDTO> actualizarCategoria(CategoriaDTO categoriaDTO) {
        return categoriaRepository.findById(categoriaDTO.getIdCategoria())
                .flatMap(existingCategoria -> {
                    CategoriaEntity categoriaEntity = mapper.convertirDtoToEntity(categoriaDTO);
                    return categoriaRepository.save(categoriaEntity)
                            .map(mapper::convertirEntityToDto);
                });
    }

    @Override
    public Mono<Void> eliminarCategoria(Integer idCategoria) {
        return categoriaRepository.deleteById(idCategoria);
    }
    
}
