package edu.cibertec.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name="Auth", description = "Entidad para la autenticacion de usuarios")
public class AuthEntity {
    private String user;
    private String password;
}
