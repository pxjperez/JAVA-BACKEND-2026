package edu.cibertec.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.- Obtener el usuario
        UsuarioEntity usuario = usuarioRepository.findByUserAndEstado(username,1);
        // 2.- Obtener los roles del usuario
        List<GrantedAuthority> roles= new ArrayList<>();
            // Aqui va la logica para traer todos los roles de usuarios
            //for(Rol rol : listaRoles) {
            //    roles.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombre()));
            //}
            //Por simplicidad, vamos a agregar un rol ADMIN
            roles.add(new SimpleGrantedAuthority("ROLE_"+"ADMIN"));
        // 3.- Creo el objeto UserDetails
        //UserDetails userDetails = new User(usuario.getUser(), "{noop}"+usuario.getPassword(), roles);//Sin contraseña encriptada
        UserDetails userDetails = new User(usuario.getUser(), usuario.getPassword(), roles); //Con contraseña encriptada
        return userDetails;
    }
}
