package edu.cibertec.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "matricula")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmatricula")
    private Integer idMatricula;
    @Column(name = "fechamat")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaMatricula; // Si se usa local date no es necesario el date time format y en la vista debo de utilizar temporals.format en remplazo del dates.format
    @OneToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private UsuarioEntity usuario;
    @OneToOne
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    private CursoEntity curso;
    @Column(name = "estado")
    private Integer estado;

    @Transient
    private String estadoString;

    public String getEstadoString() {
        return switch (this.estado) {
                case 0 -> "Inscrito";
                case 1 -> "Pagado";
                default -> "Desconocido";
            };
    }
}