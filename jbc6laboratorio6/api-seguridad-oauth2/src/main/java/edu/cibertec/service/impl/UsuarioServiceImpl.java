package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<UsuarioEntity> listarUsuarios() {
        //return usuarioRepository.findAll().stream().filter(usuario -> usuario.getEstado() == 1).toList();
        return usuarioRepository.findByEstado(1);
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
     }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        UsuarioEntity usuarioTemp = obtenerUsuario(usuario.getIdUsuario());
        if(!usuarioTemp.getPassword().equals(usuario.getPassword())){
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        UsuarioEntity usuario = obtenerUsuario(idUsuario);
        if (usuario != null) {
            usuario.setEstado(0);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }
    
}
