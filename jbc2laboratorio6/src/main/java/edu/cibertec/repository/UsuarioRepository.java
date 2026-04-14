package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioRepository {
    public List<UsuarioEntity> listarUsuarios();
    public UsuarioEntity obtenerUsuario(Integer idUsuario);
    public UsuarioEntity validarUsuario(UsuarioEntity usuario);
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public UsuarioEntity eliminarUsuario(Integer idUsuario);
}
