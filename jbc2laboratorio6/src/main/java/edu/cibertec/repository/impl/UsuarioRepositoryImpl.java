package edu.cibertec.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;

@Service
public class UsuarioRepositoryImpl implements UsuarioRepository{

    private List<UsuarioEntity> listaUsuarios;

    public UsuarioRepositoryImpl() {
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios.add(new UsuarioEntity(1, "jdoe", "password123", "John Doe", null, true));
        this.listaUsuarios.add(new UsuarioEntity(2, "asmith", "mypassword", "Alice Smith", null, true));
        this.listaUsuarios.add(new UsuarioEntity(3, "jperezgil", "123456", "JUAN CARLOS PEREZ GIL", null, true));
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return this.listaUsuarios.stream().filter(u->u.isEstado()).toList();
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return this.listaUsuarios.stream()
                                 .filter(u -> u.getIdUsuario().equals(idUsuario))
                                 .findFirst()
                                 .orElse(null);
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return this.listaUsuarios.stream()
                                 .filter(u -> u.getUser().equals(usuario.getUser()) && u.getPassword().equals(usuario.getPassword()))
                                 .findFirst()
                                 .orElse(null);
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        usuario.setIdUsuario(this.listaUsuarios.size() + 1);
        usuario.setEstado(true);
        this.listaUsuarios.add(usuario);
        return usuario;
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        List<UsuarioEntity> listaUsuariosTemp = this.listaUsuarios.stream().map(u -> {
                                                                                        if (u.getIdUsuario().equals(usuario.getIdUsuario())) {
                                                                                            u=usuario;
                                                                                        }
                                                                                        return u;
                                                                                    }).toList();
        this.listaUsuarios = listaUsuariosTemp;
        return usuario;
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        List<UsuarioEntity> listaUsuariosTemp = this.listaUsuarios.stream().map(u -> {
                                                                                        if (u.getIdUsuario().equals(idUsuario)) {
                                                                                            u.setEstado(false);
                                                                                        }
                                                                                        return u;
                                                                                    }).toList();
        this.listaUsuarios = listaUsuariosTemp;
        return this.listaUsuarios.stream()
                                 .filter(u -> u.getIdUsuario().equals(idUsuario))
                                 .findFirst()
                                 .orElse(null);
    }
    
}
