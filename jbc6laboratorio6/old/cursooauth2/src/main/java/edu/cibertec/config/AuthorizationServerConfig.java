package edu.cibertec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder codificador;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void  configure(ClientDetailsServiceConfigurer clints) throws Exception{
        clints.inMemory()
              .withClient("cliente")//USUARIO
              .secret(codificador.encode("clave"))//CONTRASEÑA CONDIFICADA
              .authorizedGrantTypes("password", "authorizatio_code","refresh_token","implicit")//TIPO DE AUTORIZACION
              .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT","USER")//ROLES
              .scopes("read","write")//ALCANCE
              .autoApprove(true);//PARAMETRO DE CONFIGURACION
              
    }

    @Override
    public void  configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception{

        endpoint.authenticationManager(authenticationManager)
                .tokenStore(tokenStore);
    }

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }


}
