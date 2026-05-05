package edu.cibertec.mapper;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T21:40:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Homebrew)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioEntity convertirDtoToEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setIdUsuairo( usuarioDTO.getIdUsuairo() );
        usuarioEntity.setNombreUsuario( usuarioDTO.getNombreUsuario() );
        usuarioEntity.setClaveUsuario( usuarioDTO.getClaveUsuario() );
        usuarioEntity.setNombreCompletoUsuario( usuarioDTO.getNombreCompletoUsuario() );

        return usuarioEntity;
    }

    @Override
    public UsuarioDTO convertirEntityToDto(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuairo( usuarioEntity.getIdUsuairo() );
        usuarioDTO.setNombreUsuario( usuarioEntity.getNombreUsuario() );
        usuarioDTO.setClaveUsuario( usuarioEntity.getClaveUsuario() );
        usuarioDTO.setNombreCompletoUsuario( usuarioEntity.getNombreCompletoUsuario() );

        return usuarioDTO;
    }

    @Override
    public List<UsuarioEntity> convertirListDtoToListEntity(List<UsuarioDTO> listaUsuarioDTO) {
        if ( listaUsuarioDTO == null ) {
            return null;
        }

        List<UsuarioEntity> list = new ArrayList<UsuarioEntity>( listaUsuarioDTO.size() );
        for ( UsuarioDTO usuarioDTO : listaUsuarioDTO ) {
            list.add( convertirDtoToEntity( usuarioDTO ) );
        }

        return list;
    }

    @Override
    public List<UsuarioDTO> convertirListEntityToListDto(List<UsuarioEntity> listaUsuarioEntity) {
        if ( listaUsuarioEntity == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( listaUsuarioEntity.size() );
        for ( UsuarioEntity usuarioEntity : listaUsuarioEntity ) {
            list.add( convertirEntityToDto( usuarioEntity ) );
        }

        return list;
    }
}
