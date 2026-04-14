package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioRepository {
    public UsuarioEntity validarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity> listarUsuarios();
}
