package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.entity.ProductoEntity;

@Mapper
public interface ProductoMapper {
    public ProductoEntity convertirDtoToEntity(ProductoDTO productoDTO);
    public ProductoDTO convertirEntityToDto(ProductoEntity productoEntity);
    public List<ProductoEntity> convertirListDtoToListEntity(List<ProductoDTO> listaProductoDTO);
    public List<ProductoDTO> convertirListEntityToListDto(List<ProductoEntity> listaProductoEntity);
}
