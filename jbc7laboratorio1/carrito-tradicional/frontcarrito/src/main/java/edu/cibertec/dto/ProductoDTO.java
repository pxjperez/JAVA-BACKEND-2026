package edu.cibertec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTO {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaDTO categoria;
    private Double precioProducto;
    private Double anteriorPrecioProducto;
    private Integer numeroProducto;
    private String imagenProducto;
}