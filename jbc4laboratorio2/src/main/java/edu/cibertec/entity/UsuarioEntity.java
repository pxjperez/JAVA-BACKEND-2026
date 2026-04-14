package edu.cibertec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {
    private Integer idUsuario;
    private String user;
    private String password;
    private String nombreCompleto;
    private Boolean estado;
}
