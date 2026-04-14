package edu.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "auditoria")
public class AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauditoria")
    private Integer idAuditoria;
    @Column(name = "fechahora")
    private Date fechaHora;
    //@Column(name = "idusuario")
    //private Integer idUsuario;
    @OneToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private UsuarioEntity usuario;
    @Column(name = "operacion")
    private String operacion;
}
