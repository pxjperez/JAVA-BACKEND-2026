package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> listaUsuarios() {
        return usuarioRepository.listaUsuarios();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.obtenerUsuario(idUsuario);
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.validarUsuario(usuario.getUser(), usuario.getPassword());
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if(usuario != null) {
            usuario.setEstado(false);
            return  usuarioRepository.save(usuario);
        }
        return null;
    }
    
}
