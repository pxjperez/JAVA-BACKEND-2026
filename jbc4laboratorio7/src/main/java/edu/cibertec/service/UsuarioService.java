package edu.cibertec.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public List<UsuarioEntity> listarUsuarios();
    public List<UsuarioEntity> listarUsuarios(String user);
    public List<UsuarioEntity> buscarUsuario(String user, Pageable pageable);
    public List<UsuarioEntity> buscarUsuario(String user);
    public UsuarioEntity obtenerUsuario(Integer idUsuario);
    public UsuarioEntity validarUsuario(UsuarioEntity usuario);
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario);
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario);
    public UsuarioEntity eliminarUsuario(Integer idUsuario);
}
