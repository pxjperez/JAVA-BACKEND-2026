package edu.cibertec.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatriculaEntity {
    private Integer idMatricula;
    private LocalDate fechaMatricula; // Si se usa local date no es necesario el date time format y en la vista debo de utilizar temporals.format en remplazo del dates.format
    private UsuarioEntity usuario;
    private CursoEntity curso;
    private Integer estado;
    private String estadoString;

}