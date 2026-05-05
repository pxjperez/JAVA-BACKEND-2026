package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.entity.CategoriaEntity;

@Mapper
public interface CategoriaMapper {
    public CategoriaEntity convertirDtoToEntity(CategoriaDTO categoriaDTO);
    public CategoriaDTO convertirEntityToDto(CategoriaEntity categoriaEntity);
    public List<CategoriaEntity> convertirListDtoToListEntity(List<CategoriaDTO> listaCategoriaDTO);
    public List<CategoriaDTO> convertirListEntityToListDto(List<CategoriaEntity> listaCategoriaEntity);
}
