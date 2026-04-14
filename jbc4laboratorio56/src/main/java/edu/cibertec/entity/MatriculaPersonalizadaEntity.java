package edu.cibertec.entity;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SqlResultSetMapping(name = "MatriculaPersonalizadaMapping",//Establece el mapeo de resultados de una consulta nativa a una clase personalizada
        classes = @ConstructorResult(
            targetClass = MatriculaPersonalizadaEntity.class,
            columns = {
                @ColumnResult(name = "idMatricula", type = Integer.class),
                @ColumnResult(name = "nombreUsuario", type = String.class),
                @ColumnResult(name = "nombreCurso", type = String.class),
                @ColumnResult(name = "estado", type = Integer.class)
            }
        )
    )
public class MatriculaPersonalizadaEntity {
    private Integer idMatricula;
    private String nombreUsuario;
    private String nombreCurso;
    private Integer estado;
    private String estadoString;


    
    public MatriculaPersonalizadaEntity(Integer idMatricula, String nombreUsuario, String nombreCurso, Integer estado) {
        this.idMatricula = idMatricula;
        this.nombreUsuario = nombreUsuario;
        this.nombreCurso = nombreCurso;
        this.estado = estado;
    }



    public String getEstadoString() {
        return this.estadoString=switch (this.estado) {
                case 0 -> "Inscrito";
                case 1 -> "Pagado";
                default -> "Desconocido";
            };
    }
    
}
