package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private Integer codigo;
    @Column(nullable = false,length = 10)
    private float precio;
    @Column(nullable = false,length = 10)
    private Integer capacidad;
    @Column(nullable = false)
    private String numeroHabitacion;
    @Column(nullable = false,length = 15)
    private String estado;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;
    
    @OneToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitaciones;

    @OneToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<Foto>fotos;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica>caracteristicas;

    @ManyToMany
    @ToString.Exclude
    private List<Cama> camas;

    public Habitacion(Integer codigo, float precio, Integer capacidad,String numeroHabitacion ,Hotel hotel, String estado) {
        this.codigo = codigo;
        this.precio = precio;
        this.capacidad = capacidad;
        this.numeroHabitacion= numeroHabitacion;
        this.hotel = hotel;
        this.estado = estado;
    }
}
