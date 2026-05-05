package edu.cibertec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @Column("idproducto")
    private Integer idProducto;
    @Column("nomproducto")
    private String nombreProducto;
    @Column("idcategoria")
    private Integer idCategoria;
    @Column("preproducto")
    private Double precioProducto;
    @Column("antpreproducto")
    private Double anteriorPrecioProducto;
    @Column("nueproducto")
    private Integer numeroProducto;
    @Column("imgproducto")
    private String imagenProducto;
}