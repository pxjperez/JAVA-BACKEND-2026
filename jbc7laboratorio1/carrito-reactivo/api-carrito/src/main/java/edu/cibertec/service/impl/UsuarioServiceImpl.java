package edu.cibertec.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.mapper.UsuarioMapper;
import edu.cibertec.repository.UsuarioReository;
import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioReository usuarioRepository;
    private final UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    @Override
    public Flux<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .map(mapper::convertirEntityToDto);
    }

    @Override
    public Mono<UsuarioDTO> obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .map(mapper::convertirEntityToDto);
    }

    @Override
    public Mono<UsuarioDTO> registrarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = mapper.convertirDtoToEntity(usuarioDTO);
        return usuarioRepository.save(usuarioEntity)
                .map(mapper::convertirEntityToDto);
    }

    @Override
    public Mono<UsuarioDTO> actualizarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepository.findById(usuarioDTO.getIdUsuairo())
                .flatMap(existingUsuario -> {
                    UsuarioEntity usuarioEntity = mapper.convertirDtoToEntity(usuarioDTO);
                    return usuarioRepository.save(usuarioEntity)
                            .map(mapper::convertirEntityToDto);
                });
    }

    @Override
    public Mono<Void> eliminarUsuario(Integer idUsuario) {
        return usuarioRepository.deleteById(idUsuario);
    }
}
