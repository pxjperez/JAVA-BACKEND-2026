package edu.cibertec.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Producto", description = "Entidad que representa un producto en el sistema")
public class ProductoDTO {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaDTO categoria;
    private Double precioProducto;
    private Double anteriorPrecioProducto;
    private Integer nuevoProducto;
    private String imagenProducto; 
} 