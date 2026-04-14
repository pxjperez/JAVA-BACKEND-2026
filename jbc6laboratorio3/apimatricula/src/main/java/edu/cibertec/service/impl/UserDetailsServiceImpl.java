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
        //1.- Obtener los datos del usuario desde la base de datos
        UsuarioEntity usuario = usuarioRepository.obtenerUsuario(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        //2.- Obtener la lista de roles del usuario
         // Simular la obtención de roles desde la base de datos
            //List<String> listaRoles = rolesRepository.findRolesByIdUsuario(usuario.getIdUsuario());
            List<GrantedAuthority> roles = new ArrayList<>();
            //for(String rol : listaRoles) {
                roles.add(new SimpleGrantedAuthority("ADMIN"));
            //}
        //3.- Alamancenar en la clase User
        UserDetails userDetails =  new User(usuario.getUser(),"{noop}"+usuario.getPassword(), roles);
        //4.- Retornar el objeto UserDetails
        return userDetails;
     }
    
}
