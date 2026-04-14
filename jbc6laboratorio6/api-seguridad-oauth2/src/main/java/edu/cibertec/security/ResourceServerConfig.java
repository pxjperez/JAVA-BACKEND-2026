package edu.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

	@Bean
	@Order(3)
	public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
		    http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority("SCOPE_read","SCOPE_write","SCOPE_openid","openid","ROLE_ADMIN","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/**").hasAuthority("SCOPE_write")
                        .anyRequest().authenticated()
                    )
                    .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
            return http.build();
	}
    
}

