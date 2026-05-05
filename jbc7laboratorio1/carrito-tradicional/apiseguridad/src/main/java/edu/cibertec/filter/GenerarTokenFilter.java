package edu.cibertec.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GenerarTokenFilter extends AbstractAuthenticationProcessingFilter {

    public GenerarTokenFilter(String url, AuthenticationManager authenticationManager) {
        super(request -> request.getServletPath().equals(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        InputStream body = request.getInputStream();
        UsuarioEntity user = new ObjectMapper().readValue(body, UsuarioEntity.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
            user.getUser(), user.getPassword(), new ArrayList<>()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
                String role = authResult.getAuthorities().stream()
                                        .findFirst()
                                        .map(GrantedAuthority::getAuthority)
                                        .orElse(null);
                //JwtUtil.generarToken(response, authResult.getName(), role!=null ? role.split("_")[1] : "");//Si se manaje ROLE_ROLENAME
                JwtUtil.generarToken(response, authResult.getName(), role);
            }
                
    }