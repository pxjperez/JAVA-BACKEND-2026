package edu.cibertec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UsuarioEntity {
    private Integer idUsuario;
    private String user;
    private String password;
    private String nombreApellido;
    private Boolean estado;
}
