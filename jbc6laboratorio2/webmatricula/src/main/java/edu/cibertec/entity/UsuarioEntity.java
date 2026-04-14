package edu.cibertec.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

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
    private String nombreApellido;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "estado")
    private Integer estado;
    @Transient @JsonIgnore
    private String estadoString;
    @Transient @JsonIgnore
    private String base64Foto;

    public String getEstadoString() {
        return this.estado == 1 ? "Activo" : "Inactivo";
    }

    public String getBase64Foto() {
        if (this.foto != null) {
            return java.util.Base64.getEncoder().encodeToString(this.foto);
        }
        return null;
    }
    
}
