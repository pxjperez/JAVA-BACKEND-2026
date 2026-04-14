package edu.cibertec.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UsuarioEntity {
    private Integer idUsuario;
    @Size(min=3, max=30, message="El tamaño tiene que estar entre 3 y 30")
    private String user;
    @NotBlank(message = "El password no puede estar vacio")
    @NotNull(message = "El password no puede estar nulo")
    @Size(min=6, max=8, message="El tamaño tiene que estar entre 6 y 8")
    private String password;
    @NotBlank(message = "El nombre no puede estar vacio")
    @NotNull(message = "El nombre no puede estar nulo")
    @Size(min=15, max=30, message="El tamaño tiene que estar entre 15 y 30")
    private String nombreCompleto;
    private Boolean estado;
    
    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer idUsuario, String user, String password, String nombreCompleto, Boolean estado) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
}
