package edu.cibertec.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.repository.entity.CategoriaEntity;

@Mapper
public interface CategoriaMapper {
    public CategoriaEntity convertirDtoToEntity(CategoriaDTO categoria);
    public CategoriaDTO convertirEntityToDto(CategoriaEntity categoria);
    public List<CategoriaEntity> convertirListaDtoToEntity(List<CategoriaDTO> categorias);
    public List<CategoriaDTO> convertirListaEntityToDto(List<CategoriaEntity> categorias);
}
