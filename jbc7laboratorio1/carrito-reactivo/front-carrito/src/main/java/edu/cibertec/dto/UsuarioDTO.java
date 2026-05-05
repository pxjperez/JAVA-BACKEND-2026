package edu.cibertec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    private Integer idUsuairo;
    private String nombreUsuario;
    private String claveUsuario;
    private String nombreCompletoUsuario;
}