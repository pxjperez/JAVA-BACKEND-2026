package edu.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import edu.cibertec.filter.LeerTokenFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

                // Para pruebas con Postman/JSON, deshabilitamos CSRF en este API REST
                http.csrf(csrf -> csrf.disable());
                http.authorizeExchange(exchange -> {
                        // Endpoints públicos
                        exchange.pathMatchers(HttpMethod.POST, "/api/security").permitAll();
                        // Solo ADMIN
                        exchange.pathMatchers(HttpMethod.GET, "/api/usuarios/**").hasAuthority("ADMIN");
                        exchange.pathMatchers(HttpMethod.POST, "/api/usuarios/**").hasAuthority("ADMIN");
                        exchange.pathMatchers(HttpMethod.PUT, "/api/usuarios/**").hasAuthority("ADMIN");
                        exchange.pathMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasAuthority("ADMIN");
                        // resto autenticado
                        exchange.anyExchange().authenticated();
                    }
                );
                http.httpBasic(basic -> basic.disable());      // Desactiva Basic Auth
                http.formLogin(form -> form.disable());        // Desactiva Form Login
                http.addFilterBefore(new LeerTokenFilter(),SecurityWebFiltersOrder.AUTHENTICATION);
                return (SecurityWebFilterChain) http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}