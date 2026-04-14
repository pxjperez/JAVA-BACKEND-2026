package edu.cibertec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcurso")
    private Integer idCurso;
    @Column(name="nomcurso")
    private String nomCurso; 
    @Column(name="fechainicio")
    private String fechaInicio;
    @Column(name="alumnosmin")
    private Integer alumnosMin;
    @Column(name="alumnosact")
    private Integer alumnosAct;
    @Column(name="estado")
    private Integer estado;    
}
