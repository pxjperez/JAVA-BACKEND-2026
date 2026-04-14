package edu.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor//Me genera un constructor con todos los atributos
@NoArgsConstructor//Me genera un constructor sin atributos
@Data//Me genera los métodos getters y setters
@Entity//Establece que la clase es una entidad de la base de datos(La clase mapea a una tabla de la base de datos)
@Table(name = "auditoria")//Establece el nombre de la tabla a la que se mapea la clase
public class AuditoriaEntity {
    @Id//Establece que el atributo es la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Establece que el valor del atributo se genera automáticamente por la base de datos
    @Column(name = "idauditoria")//Establece el nombre de la columna a la que se mapea el atributo
    private Integer idAuditoria;
    @Column(name = "fechahora")
    private Date fechaHora;
    @OneToOne//Establece una relación de uno a uno entre la entidad AuditoriaEntity y la entidad UsuarioEntity
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")//Establece el nombre de la columna que se utiliza para unir las dos tablas y el nombre de la columna en la tabla UsuarioEntity que se utiliza para unir las dos tablas
    private UsuarioEntity usuario;
    @Column(name = "operacion")
    private String operacion;
}
