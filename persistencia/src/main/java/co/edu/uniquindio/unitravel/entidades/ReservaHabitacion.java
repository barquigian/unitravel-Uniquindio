package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
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
    @Column(length = 10)
    private String codigo;
    @Column(nullable = false,length = 10)
    private Double precio;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Reserva reserva;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Habitacion habitacion;
}
