package edu.cibertec.service;

public class HolaMundoService {
    private String nombre;

    public HolaMundoService() {
    }

    public HolaMundoService(String nombre) {
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
}
