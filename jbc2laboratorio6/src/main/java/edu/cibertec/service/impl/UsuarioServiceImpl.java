package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    //Con lombok puedo oviarme al agregar el @Autowired colocaldo final en la variable y usando @AllArgsConstructor
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return this.usuarioRepository.listarUsuarios();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return this.usuarioRepository.obtenerUsuario(idUsuario);
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return this.usuarioRepository.validarUsuario(usuario);
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        return this.usuarioRepository.registrarUsuario(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        return this.usuarioRepository.actualizarUsuario(usuario);
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        return this.usuarioRepository.eliminarUsuario(idUsuario);
    }
    
}
