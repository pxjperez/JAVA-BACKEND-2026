package edu.cibertec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Integer idUsuario;
    @Column(name="user")
    private String user;
    @Column(name="password")
    private String password;
    @Column(name="nombreapellido")
    private String nombreApellido;
    @Column(name="foto")
    private byte[] foto;    
    @Column(name="estado")
    private Integer estado;    
}