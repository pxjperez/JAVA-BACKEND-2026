package edu.cibertec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Obtengo los datos del usuario de la BD
        UsuarioEntity usuario = usuarioRepository.findByUser(username);
        //Obtener los roles del usuario desde la BD (Simulando la carga de roles)
        List<String> listaRolesBD =  new ArrayList<>(); if(username.equals("kramos")){listaRolesBD.add("ADMIN");}else{listaRolesBD.add("USER");}   
        //Cargo los roles a la clase     
        List<GrantedAuthority> roles = new ArrayList<>();
        for (String rol : listaRolesBD) {
            roles.add(new SimpleGrantedAuthority("ROLE_"+rol));
        }
        //Sino queremos que se controle la encriptacion se adiciona "{noop}" al inicio de la contraseña
        //return new User(usuario.getUser(), "{noop}"+usuario.getPassword(),roles);
        return new User(usuario.getUser(), usuario.getPassword(),roles);
    }
}
         