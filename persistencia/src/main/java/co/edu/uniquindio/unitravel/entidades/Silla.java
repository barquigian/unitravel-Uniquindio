package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    @ManyToOne
    private Vuelo vuelo;
    @Column(nullable = false,length = 10)
    private float precio;

    @OneToMany(mappedBy = "silla")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;

    @ManyToMany(mappedBy = "sillas")
    @ToString.Exclude
    private List<Vuelo> vuelos;

}
