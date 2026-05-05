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
    private BCryptPasswordEncoder codificador;

    @Override
    public UsuarioEntity autenticar(String user, String password) {
        return usuarioRepository.findByUserAndPassword(user, password);
    }

    @Override
    public List<UsuarioEntity> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    @Override
    public void crearUsuario(UsuarioEntity usuario) {
        usuario.setPassword(codificador.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
    
}
