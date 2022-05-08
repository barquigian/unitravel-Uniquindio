package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false)
    private LocalDateTime fecha_reserva;

    @Column(nullable = false)
    private LocalDateTime fecha_inicio;

    @Column(nullable = false)
    private LocalDateTime fecha_fin;

    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)

    private Integer cantidadPersonas;
    
    private Float costoTotal;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "reserva")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitaciones;

    @OneToMany(mappedBy = "reserva")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;

    public Reserva(String s, LocalDateTime fechaReserva, LocalDateTime fechaInicio, LocalDateTime fechaFin, String reservado, int cantidadPersonas, Usuario usuario, Hotel hotel) {
    }
}
