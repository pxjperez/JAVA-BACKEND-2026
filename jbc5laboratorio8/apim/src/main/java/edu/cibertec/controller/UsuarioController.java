package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.entity.UsuarioEntity;

@RestController
@RequestMapping("apim/usuarios")
public class UsuarioController {

    @Value("${usuarios.url}")
    private  String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String listarCursos() {
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/{idUsuario}")
    public String obtenerUsuario(@PathVariable Integer idUsuario) {
        return restTemplate.getForObject(url + "/"+idUsuario, String.class);
    }

    @PostMapping
    public String crearUsuario(@RequestBody UsuarioEntity usuario) {
        return restTemplate.postForObject(url, usuario, String.class);
    }

    @PutMapping("/{idUsuario}")
    public String actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioEntity usuario) {
        restTemplate.put(url + "/"+idUsuario, usuario);
        return "Usuario actualizado correctamente";
    }

    @DeleteMapping("/{idUsuario}")
    public String eliminarUsuario(@PathVariable Integer idUsuario) {
        restTemplate.delete(url + "/"+idUsuario);
        return "Usuario eliminado correctamente";
    }
        

}
