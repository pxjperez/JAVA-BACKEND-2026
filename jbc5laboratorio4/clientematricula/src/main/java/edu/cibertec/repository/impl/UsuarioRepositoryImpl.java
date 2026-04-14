package edu.cibertec.repository.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl  implements UsuarioRepository{

    private RestTemplate restTemplate;
    
    @Value("${uri.rest.matricula}")
    private String urlApiMatricula;

    public UsuarioRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        List<UsuarioEntity> usuarios = restTemplate.getForObject(urlApiMatricula, List.class);
        //UsuarioEntity[] usuariosArray = restTemplate.getForObject(urlApiMatricula, UsuarioEntity[].class);
        //List<UsuarioEntity> usuarios = List.of(usuariosArray);
        return usuarios;
    }

    @Override
    public UsuarioEntity obtenerUsuario(Integer idUsuario) {
        String url = urlApiMatricula + "/" + idUsuario;
        UsuarioEntity usuario = restTemplate.getForObject(url, UsuarioEntity.class);
        return usuario;
    }

    @Override
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        URI location = restTemplate.postForLocation(urlApiMatricula, usuario);
        if (location == null) {
            return null;
        }
        System.out.println("Location: " + location.toString());
        //String url = urlApiMatricula + "/" + location.getPath().substring(location.getPath().lastIndexOf('/') + 1);
        String url = urlApiMatricula + "/" + location.getPath().split("/")[2];
        return restTemplate.getForObject(url, UsuarioEntity.class);
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario) {
        String url = urlApiMatricula + "/" + usuario.getIdUsuario();
        restTemplate.put(url, usuario);
        return restTemplate.getForObject(url, UsuarioEntity.class);
    }

    @Override
    public UsuarioEntity eliminarUsuario(Integer idUsuario) {
        String url = urlApiMatricula + "/" + idUsuario;
        restTemplate.delete(url);
        return restTemplate.getForObject(url, UsuarioEntity.class);
    }
}
