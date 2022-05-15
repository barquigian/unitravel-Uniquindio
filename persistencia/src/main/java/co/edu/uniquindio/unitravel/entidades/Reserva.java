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
    private LocalDateTime fechaReserva;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)

    private Integer cantidadPersonas;
    
    private double costoTotal;

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



    public Reserva(String codigo, LocalDateTime fechaReserva, LocalDateTime fechaInicio, LocalDateTime fechaFin, String estado, Integer cantidadPersonas, double costoTotal, String codigoUsuario, Integer codigoHotel) {
        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.cantidadPersonas = cantidadPersonas;
        this.costoTotal = costoTotal;
        this.usuario = usuario;
        this.hotel = hotel;
    }


}
