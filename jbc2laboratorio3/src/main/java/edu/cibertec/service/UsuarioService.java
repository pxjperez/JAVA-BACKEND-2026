package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public UsuarioEntity validarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity> listarUsuarios();
}
