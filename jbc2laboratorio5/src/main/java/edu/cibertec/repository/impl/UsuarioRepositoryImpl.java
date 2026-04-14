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
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioEntity(1,"jperezgil", "123", "Juan Perez", true,null));
        listaUsuarios.add(new UsuarioEntity(2,"mariag", "456", "Maria Garcia", true,null));
        listaUsuarios.add(new UsuarioEntity(3,"carlosl", "789", "Carlos Lopez", false,null));
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
        return this.listaUsuarios.stream().filter(p->p.getEstado()).toList();
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        usuario.setIdUsuario(this.listaUsuarios.size() + 1);
        usuario.setEstado(true);
        this.listaUsuarios.add(usuario);
        return usuario;
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return this.listaUsuarios.stream()
            .filter(u -> u.getIdUsuario().equals(idUsuario))
            .findFirst()
            .orElse(null);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        List<UsuarioEntity> listaActualizada = this.listaUsuarios.stream().map(u-> {
                                                                                    if (u.getIdUsuario().equals(usuario.getIdUsuario())) {
                                                                                        return usuario;
                                                                                    }else{
                                                                                        return u;
                                                                                    }
                                                                                }).toList();
        this.listaUsuarios = listaActualizada;
        return usuario;
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        List<UsuarioEntity> listaActualizada = this.listaUsuarios.stream().map(u-> {
                                                                                    if (u.getIdUsuario().equals(idUsuario)) {
                                                                                        u.setEstado(false);
                                                                                        return u;
                                                                                    }else{
                                                                                        return u;
                                                                                    }
                                                                                }).toList();
        this.listaUsuarios = listaActualizada;
        return obtenerUsuario(idUsuario);
    }
    
}
