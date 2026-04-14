package edu.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true) // Habilitar anotaciones de seguridad a nivel de método
public class SecurityConfig {
    //Habilitar el AutenticationManager para validar las credenciales del usuario
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
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
                //Fin
                authz.requestMatchers("/api/**").authenticated(); // Requiere autenticación para cualquier endpoint que comience con /api/
                authz.anyRequest().permitAll(); // Permite el acceso a cualquier otro endpoint sin autenticación
            }
        );
        //2.- Habilitar la autenticación básica HTTP
        http.httpBasic(Customizer.withDefaults()); // Habilita autenticación básica HTTP
        //3.- Deshabilitar el guardado de la sesion
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();

        //2.-Habilitar el formulario de login
        //Para el caso de las apis no se necesita habilitar el formulario de login, ya que se utiliza la autenticación básica HTTP, pero si se desea habilitar el formulario de login, se puede agregar la siguiente configuración:
        //3.-Habilitar el logout
        //Para el caso de las apis no se necesita habilitar el logout, ya que se utiliza la autenticación básica HTTP, pero si se desea habilitar el logout, se puede agregar la siguiente configuración:

    }
    
}
