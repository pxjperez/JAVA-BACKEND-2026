package edu.cibertec.entity;

public class ProductoEntity {
    private Integer idProducto;
    private String nombre;
    private Double precio;
    private boolean estado;

    public ProductoEntity() {
    }
    
    public ProductoEntity(Integer idProducto, String nombre, Double precio, boolean estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ProductoEntity [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", estado="
                + estado + "]";
    }
}
