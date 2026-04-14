package edu.cibertec.entity;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "nombreapellido")
    private String nombreApellido;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "estado")
    private Integer estado;
    @Transient
    private String fotoBase64;

    public String getFotoBase64(){
        if (this.foto!=null){
            return Base64.getEncoder().encodeToString(this.foto);
        }else{
            return "";
        }
    }
}
