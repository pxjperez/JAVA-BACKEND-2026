package edu.cibertec.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Categoria", description = "Entidad que representa una categoría de productos")
public class CategoriaDTO {
    private Integer idCategoria;
    private String nombreCategoria;
}