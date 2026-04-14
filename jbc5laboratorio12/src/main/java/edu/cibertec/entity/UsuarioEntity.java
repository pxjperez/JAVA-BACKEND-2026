package edu.cibertec.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
@Schema(name="Usuario", description = "Entidad que representa a un usuario del aplicativo")
@XmlRootElement(name = "usuario")//Esto se agrega en el caso de usar xml, para indicar el nombre del nodo raíz
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
    private String estadoString;

    public String getEstadoString() {
        return this.estado == 1 ? "Activo" : "Inactivo";
    }
}
