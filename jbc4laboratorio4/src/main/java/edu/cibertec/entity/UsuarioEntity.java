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

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private String nombreCompleto;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "estado")
    private Boolean estado;

    @Transient
    private String fotoBase64;
    @Transient
    private String estadoString;

    public UsuarioEntity(Integer idUsuario, String user, String password, String nombreCompleto, Boolean estado, byte[] foto) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.foto = foto;
    }
    
    public String getFotoBase64() {
        if (foto != null) {
            return "data:image/png;base64,"+Base64.getEncoder().encodeToString(foto);
        }
        return null;
    }
    public String getEstadoString() {
        return (estado != null && estado) ? "Activo" : "Inactivo";
    }
    
}