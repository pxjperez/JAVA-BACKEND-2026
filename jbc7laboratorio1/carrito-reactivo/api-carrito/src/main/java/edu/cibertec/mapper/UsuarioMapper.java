package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.entity.UsuarioEntity;

@Mapper
public interface UsuarioMapper {
    public UsuarioEntity convertirDtoToEntity(UsuarioDTO usuarioDTO);
    public UsuarioDTO convertirEntityToDto(UsuarioEntity usuarioEntity);
    public List<UsuarioEntity> convertirListDtoToListEntity(List<UsuarioDTO> listaUsuarioDTO);
    public List<UsuarioDTO> convertirListEntityToListDto(List<UsuarioEntity> listaUsuarioEntity);
}
