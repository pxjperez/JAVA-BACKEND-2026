package edu.cibertec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.AuthEntity;
import edu.cibertec.util.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/security")
@Tag(name = "Security", description = "Api para generar token de seguridad")
public class SecurityController {
    
    private final AuthenticationManager authenticationManager;

    @PostMapping
    @Operation(summary = "Generar token de seguridad")
    public void autenticacion(@RequestBody AuthEntity usuario, HttpServletResponse response) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUser(), usuario.getPassword()));
        if (auth.isAuthenticated()) {
            JwtUtil.generarToken(response, auth); 
        }else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
    
}
