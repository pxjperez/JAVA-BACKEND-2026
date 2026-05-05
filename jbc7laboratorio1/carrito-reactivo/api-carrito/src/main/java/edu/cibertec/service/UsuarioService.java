package edu.cibertec.service;

import edu.cibertec.dto.UsuarioDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    public Flux<UsuarioDTO> listarUsuarios();
    public Mono<UsuarioDTO> obtenerUsuario(Integer idUsuario);
    public Mono<UsuarioDTO> registrarUsuario(UsuarioDTO usuarioDTO);
    public Mono<UsuarioDTO> actualizarUsuario(UsuarioDTO usuarioDTO);
    public Mono<Void> eliminarUsuario(Integer idUsuario);
}
