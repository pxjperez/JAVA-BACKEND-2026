package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.UsuarioDTO;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.repository.mapper.UsuarioMapper;
import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return mapper.convertirListaEntityToDto(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuario(Integer idUsuario) {
        return mapper.convertirEntityToDto(usuarioRepository.findById(idUsuario).orElse(null)); 
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario) {
        return mapper.convertirEntityToDto(usuarioRepository.save(mapper.convertirDtoToEntity(usuario)));
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuario) {
        return mapper.convertirEntityToDto(usuarioRepository.save(mapper.convertirDtoToEntity(usuario)));
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
    
}
