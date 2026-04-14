package edu.cibertec.service;

import java.util.List;

import edu.cibertec.entity.UsuarioEntity;

public interface UsuarioService {
    public UsuarioEntity autenticar (String user, String password);
    public List<UsuarioEntity> listarUsuario();
    public UsuarioEntity obtenerUsuario (Integer idUsuario);
    public void crearUsuario(UsuarioEntity usuario); 
    public void eliminarUsuario(Integer idUsuario);
}
