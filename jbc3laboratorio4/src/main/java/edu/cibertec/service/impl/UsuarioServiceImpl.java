package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;
import edu.cibertec.service.UsuarioService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    //Con lombok puedo oviarme al agregar el @Autowired colocaldo final en la variable y usando @AllArgsConstructor
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        //return usuarioRepository.findAll().stream().filter(p->p.isEstado()).toList();
        return usuarioRepository.listaUsuario(); //Esta es mas eficiente
    }
    

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public UsuarioEntity validarUsuario(UsuarioEntity usuario) {
        //return usuarioRepository.validarUsuario(usuario.getUser(), usuario.getPassword());
        return usuarioRepository.findByUserAndPassword(usuario.getUser(), usuario.getPassword());
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        usuario.setEstado(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        UsuarioEntity usuario = obtenerUsuario(idUsuario);
        if (usuario != null) {
            usuario.setEstado(false);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

    @Override
    public List<UsuarioEntity> listarUsuarios(String user) {
        return usuarioRepository.listarUsuarios(user);
    }


    @Override
        public List<UsuarioEntity> buscarUsuario(String user, Pageable pageable) {
            return usuarioRepository.findByEstadoTrueAndUserContaining(user, pageable);
    }
    @Override
        public List<UsuarioEntity> buscarUsuario(String user) {
            return usuarioRepository.findByEstadoTrueAndUserContaining(user);
    }
}
