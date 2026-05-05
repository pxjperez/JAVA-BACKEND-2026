package edu.cibertec.service;

import java.util.List;

import edu.cibertec.dto.UsuarioDTO;

public interface UsuarioService {
    public List<UsuarioDTO> listarUsuarios();
    public UsuarioDTO obtenerUsuario(Integer idUsuario);
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario);
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuario);
    public void eliminarUsuario(Integer idUsuario);
}
