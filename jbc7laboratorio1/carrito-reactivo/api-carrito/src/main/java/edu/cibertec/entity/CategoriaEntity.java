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
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @Column("idcategoria")
    private Integer idCategoria;
    @Column("nomcategoria")
    private String nombreCategoria;
}