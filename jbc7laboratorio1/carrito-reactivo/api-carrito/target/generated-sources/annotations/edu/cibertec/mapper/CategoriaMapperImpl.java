package edu.cibertec.mapper;

import edu.cibertec.dto.CategoriaDTO;
import edu.cibertec.entity.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T21:40:18-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Homebrew)"
)
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaEntity convertirDtoToEntity(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setIdCategoria( categoriaDTO.getIdCategoria() );
        categoriaEntity.setNombreCategoria( categoriaDTO.getNombreCategoria() );

        return categoriaEntity;
    }

    @Override
    public CategoriaDTO convertirEntityToDto(CategoriaEntity categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setIdCategoria( categoriaEntity.getIdCategoria() );
        categoriaDTO.setNombreCategoria( categoriaEntity.getNombreCategoria() );

        return categoriaDTO;
    }

    @Override
    public List<CategoriaEntity> convertirListDtoToListEntity(List<CategoriaDTO> listaCategoriaDTO) {
        if ( listaCategoriaDTO == null ) {
            return null;
        }

        List<CategoriaEntity> list = new ArrayList<CategoriaEntity>( listaCategoriaDTO.size() );
        for ( CategoriaDTO categoriaDTO : listaCategoriaDTO ) {
            list.add( convertirDtoToEntity( categoriaDTO ) );
        }

        return list;
    }

    @Override
    public List<CategoriaDTO> convertirListEntityToListDto(List<CategoriaEntity> listaCategoriaEntity) {
        if ( listaCategoriaEntity == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( listaCategoriaEntity.size() );
        for ( CategoriaEntity categoriaEntity : listaCategoriaEntity ) {
            list.add( convertirEntityToDto( categoriaEntity ) );
        }

        return list;
    }
}
