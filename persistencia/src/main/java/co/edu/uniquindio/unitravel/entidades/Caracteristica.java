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
    private String codigo;
    @Column(length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "caracteristicasHotel")
    @ToString.Exclude
    private List<Hotel>hoteles;

    @ManyToMany(mappedBy = "caracteristicasHabitacion")
    @ToString.Exclude
    private List<Habitacion>habitaciones;
}
