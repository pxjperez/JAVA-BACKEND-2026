package edu.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.Customizer;
import edu.cibertec.filter.LeerTokenFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return (SecurityWebFilterChain) http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange -> exchange

                        // Endpoints públicos
                        .pathMatchers(HttpMethod.POST, "/api/security").permitAll()
                        .pathMatchers(HttpMethod.GET, "/api/usuarios/test/**").permitAll()

                        // Solo ADMIN
                        .pathMatchers(HttpMethod.GET, "/api/usuarios/**").hasAuthority("ADMIN")
                        .pathMatchers(HttpMethod.POST, "/api/usuarios/**").hasAuthority("ADMIN")
                        .pathMatchers(HttpMethod.PUT, "/api/usuarios/**").hasAuthority("ADMIN")
                        .pathMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasAuthority("ADMIN")

                        // resto autenticado
                        .anyExchange().authenticated()
                )
                .httpBasic(basic -> basic.disable())      // Desactiva Basic Auth
                .formLogin(form -> form.disable())        // Desactiva Form Login
                .addFilterBefore(new LeerTokenFilter(),SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}