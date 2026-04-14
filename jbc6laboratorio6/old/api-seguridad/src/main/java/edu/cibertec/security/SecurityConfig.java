package edu.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authConfig;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //La sesion no queda almacenada en el servidor
        http.csrf(c->c.disable());
        http.authorizeHttpRequests( //Aqui se puede personalizar los acceso de un rol especifico
                    auth ->{
                        //Dinamicamente
                        // List<RolEntity> listaRoles = rolesService.listarRoles();                        
                        // listaRoles.forEach(role -> {
                        //      List<AccesoEntity>  listaAccesos = accesosService.listarAccesos(role.getIdRol());
                        //      listaAccesos.forEach(acceso -> {
                        //           auth.requestMatchers(acceso.getUrl()).hasRole(role.getNombre());
                        //      });
                        //  });
                        //Manualmente
                        auth.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();//Sin autenticar
                        //Las url de los recursos privados
                        //auth.requestMatchers("api/v1/usuarios/**").hasRole("ADMIN");//Rol ADMIN // Se debe de habilitar cuando cuando le envie el rol
                        //auth.requestMatchers(HttpMethod.GET,"api/v1/usuarios/**").hasRole("ADMIN");//Rol ADMIN
                        auth.anyRequest().authenticated(); //Autenticado
                    }
        );
        http.httpBasic(Customizer.withDefaults());//Esta linea es remplazada por el addFilterBefore
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
