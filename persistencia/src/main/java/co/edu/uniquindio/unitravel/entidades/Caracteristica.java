package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private Integer codigo;
    @Column(length = 100)
    private String nombre;
@Column(length = 10)
    private String tipo;

    @ManyToMany(mappedBy = "caracteristicas")
    @ToString.Exclude
    private List<Hotel>hoteles;

    @ManyToMany(mappedBy = "caracteristicas")
    @ToString.Exclude
    private List<Habitacion>habitaciones;

    public Caracteristica(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
