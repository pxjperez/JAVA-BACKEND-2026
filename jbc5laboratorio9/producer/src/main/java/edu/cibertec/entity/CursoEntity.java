package edu.cibertec.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nombreCurso;
    @Column(name = "fechainicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;
    @Column(name = "alumnosmin")
    private Integer alumnosMinimo;
    @Column(name = "alumnosact")
    private Integer alumnosActual;
    @Column(name = "estado")
    private Integer estado;
    @Transient @JsonIgnore //Establece que el atributo no se mapea a ninguna columna de la tabla de la base de datos
    private String estadoString;

    public String getEstadoString(){
        String resultado ="";
        switch (this.estado) {
            case 0:
                resultado="DESHABILITADO";
                break;
            case 1:
                resultado="CREADO";
                break;
            case 2:
                resultado="EN PROCESO DE VENTA";
                break;
            case 3:
                resultado="COMPLETO";
                break;
            default:
                resultado="-ESTADO-";
                break;
        }
        return resultado;
    }
}