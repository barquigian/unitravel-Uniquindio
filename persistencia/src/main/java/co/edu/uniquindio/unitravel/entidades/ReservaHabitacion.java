package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaHabitacion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;
    @Column(nullable = false,length = 10)
    private Double precio;
    @ManyToOne
    private Reserva reserva;
    @ManyToOne
    private Habitacion habitacion;
}
