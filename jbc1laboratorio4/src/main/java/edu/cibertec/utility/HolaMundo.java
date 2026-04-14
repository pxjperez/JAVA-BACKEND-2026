package edu.cibertec.utility;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class HolaMundo {
    private String nombre;

    public HolaMundo() {
    }

    public HolaMundo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String saludar() {
        if(this.nombre != null && !this.nombre.isEmpty()) {
            return "¡Hola, " + this.nombre + "!";
        } else {
            return "¡Hola, Mundo!";
        }
    }

    @PostConstruct
    public void imprimirAlInicializar() {
        System.out.println("HolaMundoService ha sido inicializado: "+this.nombre);
    }

    @PreDestroy
    public void imprimirAlDestruir() {
        System.out.println("HolaMundoService está siendo destruido: "+this.nombre);
    }
}
