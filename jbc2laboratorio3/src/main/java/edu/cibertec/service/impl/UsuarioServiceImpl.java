package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.validarUsuario(usuario);
     }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }
    
}
