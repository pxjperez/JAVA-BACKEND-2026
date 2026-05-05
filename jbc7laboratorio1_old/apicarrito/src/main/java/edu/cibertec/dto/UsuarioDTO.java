package edu.cibertec.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@Schema(name = "Usuario", description = "Entidad que representa un usuario del sistema")
public class UsuarioDTO{
    private Integer idUsuario;
    private String nombreUsuario;
    private String claveUsuario;
    private String nombreCompletoUsuario;
}
