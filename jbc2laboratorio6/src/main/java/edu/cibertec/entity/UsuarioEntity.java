package edu.cibertec.entity;

import java.util.Base64;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data // Genera los getters y setters automaticamente
@AllArgsConstructor //Nos genera un constructor con todos los atributos
//@RequiredArgsConstructor//Nos genera un constructor con los atributos obligatorios que tienen la palabra final
@NoArgsConstructor//Nos genera un constructor sin atributos
@ToString
public class UsuarioEntity {
    private Integer idUsuario;
    @Size(min = 4, max = 20, message = "El user debe tener entre 4 y 20 caracteres")
    private String user;
    @Size(min = 4, max = 20, message = "El password debe tener entre 4 y 20 caracteres")
    @NotBlank(message = "El password no puede estar vacio")
    @NotNull(message = "El password no puede ser nulo")
    private String password;
    private String nombreCompleto;
    private byte[] foto;
    private boolean estado;
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
        if (foto != null) {
            this.fotoString = "data:image/png;base64," + Base64.getEncoder().encodeToString(this.foto);
        }
        return this.fotoString;
    }

}
