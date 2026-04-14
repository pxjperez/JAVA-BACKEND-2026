package edu.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries(
    {
        @NamedQuery(
            name = "CursoEntity.abiertoIncompleto",
            query = "SELECT c FROM CursoEntity c WHERE c.estado=1 AND (c.alumnosMinimo - c.alumnosActual) > 0"
        ),
    }
)
@NamedNativeQueries(
    {
        @NamedNativeQuery(
            name = "CursoEntity.abiertoIncompletoNativo",
            query = "SELECT * FROM curso WHERE estado=1 AND (alumnosmin - alumnosact) > 0"
        ),
    }
)
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nombreCurso;
    @Column(name = "fechainicio")
    private Date fechaInicio;
    @Column(name = "alumnosmin")
    private Integer alumnosMinimo;
    @Column(name = "alumnosact")
    private Integer alumnosActual;
    @Column(name = "estado")
    private Integer estado;
    @Transient
    private String estadoString;

    public String getEstadoString(){
        String resultado ="";
        switch (this.estado) {
            case 0:
                resultado="CREADO";
                break;
            case 1:
                resultado="EN PROCESO DE VENTA";
                break;
            case 2:
                resultado="COMPLETO";
                break;
            default:
                resultado="-ESTADO-";
                break;
        }
        return resultado;
    }
}