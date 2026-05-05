package edu.cibertec.mapper;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.entity.ProductoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-06T21:40:17-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Homebrew)"
)
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoEntity convertirDtoToEntity(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setIdProducto( productoDTO.getIdProducto() );
        productoEntity.setNombreProducto( productoDTO.getNombreProducto() );
        productoEntity.setPrecioProducto( productoDTO.getPrecioProducto() );
        productoEntity.setAnteriorPrecioProducto( productoDTO.getAnteriorPrecioProducto() );
        productoEntity.setNumeroProducto( productoDTO.getNumeroProducto() );
        productoEntity.setImagenProducto( productoDTO.getImagenProducto() );

        return productoEntity;
    }

    @Override
    public ProductoDTO convertirEntityToDto(ProductoEntity productoEntity) {
        if ( productoEntity == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setIdProducto( productoEntity.getIdProducto() );
        productoDTO.setNombreProducto( productoEntity.getNombreProducto() );
        productoDTO.setPrecioProducto( productoEntity.getPrecioProducto() );
        productoDTO.setAnteriorPrecioProducto( productoEntity.getAnteriorPrecioProducto() );
        productoDTO.setNumeroProducto( productoEntity.getNumeroProducto() );
        productoDTO.setImagenProducto( productoEntity.getImagenProducto() );

        return productoDTO;
    }

    @Override
    public List<ProductoEntity> convertirListDtoToListEntity(List<ProductoDTO> listaProductoDTO) {
        if ( listaProductoDTO == null ) {
            return null;
        }

        List<ProductoEntity> list = new ArrayList<ProductoEntity>( listaProductoDTO.size() );
        for ( ProductoDTO productoDTO : listaProductoDTO ) {
            list.add( convertirDtoToEntity( productoDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductoDTO> convertirListEntityToListDto(List<ProductoEntity> listaProductoEntity) {
        if ( listaProductoEntity == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( listaProductoEntity.size() );
        for ( ProductoEntity productoEntity : listaProductoEntity ) {
            list.add( convertirEntityToDto( productoEntity ) );
        }

        return list;
    }
}
