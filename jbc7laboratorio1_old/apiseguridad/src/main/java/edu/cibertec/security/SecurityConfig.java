package edu.cibertec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.cibertec.filter.GenerarTokenFilter;
import edu.cibertec.filter.LeerTokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationConfiguration auth;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return auth.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        //Se adiciona STATELESS para que no guarde sesion
        http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // Para pruebas con Postman/JSON, deshabilitamos CSRF en este API REST
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests((authz) -> {
                    //Logica para traer de la bd los roles y accesos
                    //for( ... ){
                    //    authz.requestMatchers("...").hasRole("...");
                    //}
                    // Endpoints públicos
                    authz.requestMatchers(HttpMethod.GET, "/api/security").permitAll();
                    authz.requestMatchers(HttpMethod.GET, "/api/usuarios/test/**").permitAll();
                    authz.requestMatchers(HttpMethod.GET, "/api/usuarios/**").hasAuthority("ADMIN");//(Recomendado)
                    //authz.requestMatchers(HttpMethod.GET, "/api/usuarios/**").hasAnyRole("ADMIN");
                    // Permitir registrar usuario sin autenticación (POST /api/usuarios)
                    authz.requestMatchers(HttpMethod.POST, "/api/usuarios/**").hasAuthority("ADMIN");//(Recomendado)
                    //authz.requestMatchers(HttpMethod.POST, "/api/usuarios/**").hasAnyRole("ADMIN");

                    // Endpoints protegidos (update/delete requieren ADMIN)
                    authz.requestMatchers(HttpMethod.PUT, "/api/usuarios/**").hasAuthority("ADMIN"); //ROLE_ADMIN si en el loadUserByUsername usamos "ROLE_"+rol sino solo "ADMIN"
                    authz.requestMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasAuthority("ADMIN"); //ROLE_ADMIN si en el loadUserByUsername usamos "ROLE_"+rol sino solo "ADMIN"
                    authz.anyRequest().authenticated();
            }
            );
        //Habilitar Basic Auth
        //http.httpBasic(Customizer.withDefaults());
        //Agregar filtro para generar token
        http.addFilterBefore(new GenerarTokenFilter("/api/security", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new LeerTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
