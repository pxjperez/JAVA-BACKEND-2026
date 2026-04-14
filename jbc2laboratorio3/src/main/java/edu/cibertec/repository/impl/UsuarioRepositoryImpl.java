package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private List<UsuarioEntity> listaUsuarios;

    

    public UsuarioRepositoryImpl() {
        listaUsuarios = List.of(
            new UsuarioEntity("jperezgil", "123", "Juan", "Perez", true),
            new UsuarioEntity("mariag", "456", "Maria", "Garcia", true),
            new UsuarioEntity("carlosl", "789", "Carlos", "Lopez", false)
        );
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        return this.listaUsuarios.stream()
            .filter(u -> u.getUser().equals(usuario.getUser()) && u.getPassword().equals(usuario.getPassword()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return this.listaUsuarios;
    }
    
}
