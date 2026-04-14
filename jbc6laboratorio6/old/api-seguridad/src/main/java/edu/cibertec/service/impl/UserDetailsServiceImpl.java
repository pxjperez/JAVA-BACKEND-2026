package edu.cibertec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByUserAndEstado(username,1);
        List<GrantedAuthority> roles = new ArrayList<>();
        if(usuario != null){
            if(usuario.getUser().equals("jperezgil")){
                roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            }else{
                roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }           
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        
        return new User(usuario.getUser(), usuario.getPassword(), roles);
    }
    
}
