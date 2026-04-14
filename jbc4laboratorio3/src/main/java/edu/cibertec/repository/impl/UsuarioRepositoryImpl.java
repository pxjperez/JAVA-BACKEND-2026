package edu.cibertec.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private List<UsuarioEntity> listaUsuarios;

    public UsuarioRepositoryImpl() {
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios.addAll(List.of(
            new UsuarioEntity(1, "jperezgil", "123456", "JUAN PEREZ", true),
            new UsuarioEntity(2, "asmith", "mypassword", "Alice Smith", true),
            new UsuarioEntity(3, "bjones", "securepass", "Bob Jones", false)
        ));
    }

    @Override
    public List<UsuarioEntity> listaUsuarios() {
        return this.listaUsuarios;
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
        usuario.setEstado(true);
        usuario.setIdUsuario(this.listaUsuarios.size() + 1);
        this.listaUsuarios.add(usuario);
        return usuario;
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        this.listaUsuarios = this.listaUsuarios.stream()
            .map(u -> {
                if (u.getIdUsuario().equals(usuario.getIdUsuario())) {
                    return usuario;
                }else{
                    return u;
                }
            })
            .toList();
        return usuario;
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        this.listaUsuarios = this.listaUsuarios.stream()
            .map(u -> {
                if (u.getIdUsuario().equals(idUsuario)) {
                    u.setEstado(false);
                    return u;
                }else{
                    return u;
                }
            })
            .toList();
        return this.listaUsuarios.stream()
                .filter(u -> u.getIdUsuario().equals(idUsuario))
                .findFirst()
                .orElse(null);
    }
    
}
