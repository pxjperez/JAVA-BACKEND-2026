package edu.cibertec.util;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpHeaders;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import static java.util.Collections.emptyList;

@Component
public class JwtUtil {
    // Clave secreta para firmar el JWT
    private static SecretKey SECRET_KEY;

    public JwtUtil(@Value("${security.jwt.secret-key}") String secretKeyString) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(secretKeyString.getBytes());
    }

    public static Authentication leerToken(ServerWebExchange exchange) {
        try {
            String authHeader = exchange.getRequest()
                                        .getHeaders()//Obtiene los encabezados de la solicitud
                                        .getFirst(HttpHeaders.AUTHORIZATION);//Obtiene el valor del encabezado "Authorization"

            if (authHeader != null || authHeader.startsWith("Bearer ")) {
                String token = authHeader.replace("Bearer ", "");//Elimina el prefijo "Bearer " para obtener solo el token

                Claims claims = Jwts.parser()
                                    .verifyWith((SecretKey) SECRET_KEY)//Valida la llave de seguridad
                                    .build()
                                    .parseSignedClaims(token)
                                    .getPayload();//Obtiene los claims del token

                String user = claims.getSubject();// Obtiene el usuario
                String role = claims.get("role", String.class);// Obtiene el rol
                List<GrantedAuthority> roles = List.of(new SimpleGrantedAuthority(role));
                return new UsernamePasswordAuthenticationToken(user, null, roles);
            }else{
                return null;
            }

        } catch (Exception ex) {
            return null;
        }
    }

}
