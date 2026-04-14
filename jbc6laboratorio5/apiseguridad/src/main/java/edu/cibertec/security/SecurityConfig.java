package edu.cibertec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true) // Habilitar anotaciones de seguridad a nivel de método
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;
    //Habilitar el AutenticationManager para validar las credenciales del usuario
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Habilitamos el AutenticationFilter para validar las credenciales del usuario y la autorizacion
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //1.- Configuraciones de Autorizacion y Autenticacion
        http.csrf(csrf->csrf.disable()); // Deshabilitar CSRF para pruebas (no recomendado para producción)
        http.authorizeHttpRequests(
            authz->{
                //Aqui definimos a que url tiene acceso cada rol - Inicio
                //authz.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
                //authz.requestMatchers("/user/**").hasAnyRole("ADMIN");
                authz.requestMatchers(HttpMethod.POST, "/api/security").permitAll();
                authz.requestMatchers(HttpMethod.POST,"/api/usuarios").permitAll();
                //Fin
                authz.requestMatchers("/api/**").authenticated(); // Requiere autenticación para cualquier endpoint que comience con /api/
                authz.anyRequest().permitAll(); // Permite el acceso a cualquier otro endpoint sin autenticación
            }
        );
        //2.- Habilitar la autenticación básica HTTP
        //http.httpBasic(Customizer.withDefaults()); // Se deshabilita para agregar los filtros
        //2.- Agregar filtro para generar token
        http.addFilterBefore(new GenerarTokenFilter("/api/security2", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new LeerTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //3.- Deshabilitar el guardado de la sesion
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
    
}
