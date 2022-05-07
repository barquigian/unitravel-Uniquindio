package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaSilla implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false,length = 10)
    private float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Silla silla;

    public ReservaSilla(String codigo, int numeroSilla, float precio ) {
    }
}
