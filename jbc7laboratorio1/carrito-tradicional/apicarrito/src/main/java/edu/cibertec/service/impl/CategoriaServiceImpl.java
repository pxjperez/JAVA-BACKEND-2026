package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.CategoriaRepository;
import edu.cibertec.repository.mapper.CategoriaMapper;
import edu.cibertec.service.CategoriaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private CategoriaMapper mapper = Mappers.getMapper(CategoriaMapper.class);

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return mapper.convertirListaEntityToDto(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO obtenerCategoria(Integer idCategoria) {
        return mapper.convertirEntityToDto(categoriaRepository.findById(idCategoria).orElse(null));
    }

    @Override
    public CategoriaDTO registrarCategoria(CategoriaDTO categoria) {
        return mapper.convertirEntityToDto(categoriaRepository.save(mapper.convertirDtoToEntity(categoria)));
    }

    @Override
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoria) {
        return mapper.convertirEntityToDto(categoriaRepository.save(mapper.convertirDtoToEntity(categoria)));
    }

    @Override
    public void eliminarCategoria(Integer idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
    
}
