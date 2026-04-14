package edu.cibertec.entity;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor //Nos genera un constructor con todos los atributos
//@RequiredArgsConstructor//Nos genera un constructor con los atributos obligatorios que tienen la palabra final
@NoArgsConstructor//Nos genera un constructor sin atributos
@Data // Genera los getters y setters automaticamente
@ToString
@Entity //Indica que esta clase es una entidad y se mapea con una tabla de la base de datos
@Table(name = "usuario") //Indica el nombre de la tabla en la base de datos con la que se mapea esta entidad
public class UsuarioEntity {
    @Id //Indica que este atributo es la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el valor de este atributo se genera automaticamente por la base de datos
    @Column(name = "idusuario") //idUsuario => id_usuario //Siempre tiene que estar en minuscula asi sea que en la BD este en mayuscula
    private Integer idUsuario; //id_usuario
    @Size(min = 4, max = 20, message = "El user debe tener entre 4 y 20 caracteres")
    @Column(name = "user") // Indica el nombre de la columna en la tabla de la base de datos con la que se mapea este atributo
    private String user;
    @Size(min = 4, max = 20, message = "El password debe tener entre 4 y 20 caracteres")
    @NotBlank(message = "El password no puede estar vacio")
    @NotNull(message = "El password no puede ser nulo")
    @Column(name = "password")
    private String password;
    @Column(name = "nombreapellido")
    private String nombreCompleto;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "estado")
    private boolean estado;
    @Transient
    private String fotoString;

    public UsuarioEntity(Integer idUsuario, String user, String password, String nombreCompleto, byte[] foto,  boolean estado) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.foto = foto;
        this.estado = estado;
    }

    public String getFotoString() {
        if (this.foto != null) {
            this.fotoString = "data:image/png;base64," + Base64.getEncoder().encodeToString(this.foto);
        }
        return this.fotoString;
    }
}