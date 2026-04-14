package edu.cibertec.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {
    private Integer idUsuario;
    private String user;
    private String password;
    private String nombreApellido;
    private byte[] foto;
    private Integer estado;
    private String estadoString;
    public String getEstadoString() {
        return this.estado == 1 ? "Activo" : "Inactivo";
    }
}
