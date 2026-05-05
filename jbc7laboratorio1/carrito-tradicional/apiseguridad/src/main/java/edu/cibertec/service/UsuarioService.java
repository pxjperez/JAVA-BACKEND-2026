package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public List<UsuarioEntity> listaUsuarios();
    public UsuarioEntity obtenerUsuario(Integer idUsuario);
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public void eliminarUsuario(Integer idUsuario);
}
