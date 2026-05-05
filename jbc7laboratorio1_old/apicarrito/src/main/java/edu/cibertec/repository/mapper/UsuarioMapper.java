package edu.cibertec.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.entity.UsuarioEntity;

@Mapper
public interface UsuarioMapper {
    public UsuarioEntity convertirDtoToEntity(UsuarioDTO usuario);
    public UsuarioDTO convertirEntityToDto(UsuarioEntity usuario);
    public List<UsuarioEntity> convertirListaDtoToEntity(List<UsuarioDTO> usuarios);
    public List<UsuarioDTO> convertirListaEntityToDto(List<UsuarioEntity> usuarios);
}
