package edu.cibertec.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.entity.ProductoEntity;

@Mapper
public interface ProductoMapper {
    public ProductoEntity convertirDtoToEntity(ProductoDTO producto);
    public ProductoDTO convertirEntityToDto(ProductoEntity producto);
    public List<ProductoEntity> convertirListaDtoToEntity(List<ProductoDTO> productos);
    public List<ProductoDTO> convertirListaEntityToDto(List<ProductoEntity> productos);
}
