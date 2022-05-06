package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;
    @Column(length = 200, nullable = false)
    private String nombre;
    @Column(length = 50,nullable = false, unique = true)
    @Email
    private String email;
    @Column(length = 10)
    private String contrasena;
}
