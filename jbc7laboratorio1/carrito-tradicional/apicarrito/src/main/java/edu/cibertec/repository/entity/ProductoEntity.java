package edu.cibertec.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer idProducto;
    @Column(name = "nomproducto")
    private String nombreProducto;
    @OneToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private CategoriaEntity categoria;
    @Column(name = "preproducto")
    private Double precioProducto;
    @Column(name = "antpreproducto")
    private Double anteriorPrecioProducto;
    @Column(name = "nueproducto")
    private Integer nuevoProducto;
    @Column(name = "imgproducto")
    private String imagenProducto; 
} 