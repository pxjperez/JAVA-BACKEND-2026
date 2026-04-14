package edu.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
            //En esta parte se maneja la autorizacion y la autenticacion
            http.authorizeHttpRequests((authz) -> {
                    //1.- Se defina la autorizacion de las url
                    //Lis de url y los respectivos roles que pueden acceder a cada url
                    //List<UrlEntity> listaUrl = urlService.listarUrls();
                    //for(url : listaUrl) {
                          //List<RolEntity> listaRoles = rolService.obtenerRolDeLaUrl(url.idUrl);
                          //for(String rol : listaRoles) {
                          //authz.requestMatchers(url).hasAnyAuthority(rol);   
                          //}
                    //}
                    authz.requestMatchers("/js/**").permitAll();
                    authz.requestMatchers("/css/**").permitAll();
                    authz.requestMatchers("/img/**").permitAll();
                    authz.requestMatchers("/admin/**").hasAnyAuthority("ADMIN");
                    //2.- Definir la autenticacion del sistema
                    authz.anyRequest().authenticated();
                 }
            );
            //Se habilita el formulario de login
            http.formLogin(login -> {
                login.loginPage("/login").permitAll();//Especifico la url del formulario de logeo
                login.usernameParameter("txtUser"); //Especifico el nombre del campo username del fomulario de logeo
                login.passwordParameter("txtPassword");//Especifico el nombre del campo password del fomulario de logeo
                //Es obligatoria en una aplicacion web para que no genera confligto
                login.defaultSuccessUrl("/", true);//Si el logeo fue exitoso redirecciona a la pagina principal
            });
            //Se habilita el logout
            http.logout(logout -> {
                logout.logoutUrl("/logout");//Especifico la url para cerrar sesion
                logout.logoutSuccessUrl("/login?logout");//Si el logout fue exitoso redirecciona a la pagina de login con un mensaje de logout exitoso
                logout.invalidateHttpSession(true);//Invalida la sesion del usuario
                logout.deleteCookies("JSESSIONID");//Elimina las cookies de la sesion
                logout.permitAll();//Permite el acceso a la url de logout a todos los usuarios
            });
        return http.build();//Construye el objeto SecurityFilterChain con la configuracion definida
    }
}
