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
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @Column("idusuario")
    private Integer idUsuairo;
    @Column("nomusuario")
    private String nombreUsuario;
    @Column("clausuario")
    private String claveUsuario;
    @Column("nomcomusuario")
    private String nombreCompletoUsuario;
}