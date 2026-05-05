package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository  usuarioRepository;
    private final BCryptPasswordEncoder codifiador;
    @Override
    public List<UsuarioEntity> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        usuario.setPassword(codifiador.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        usuario.setPassword(codifiador.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        //Eliminacion logica
        UsuarioEntity usuario=obtenerUsuario(idUsuario);
        if(usuario!=null){
            usuario.setEstado(0);
            usuarioRepository.save(usuario); 
        }
    }
    
}
