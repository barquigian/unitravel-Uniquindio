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
    @Column(length = 10)
    private String codigo;
    @Column(nullable = false,length = 10)
    private float precio;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Vuelo vuelo;
    
    @OneToMany(mappedBy = "silla")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;

    @ManyToMany(mappedBy = "sillas")
    @ToString.Exclude
    private List<Vuelo> vuelos;

    public Silla(String codigo, float precio, Vuelo vuelo) {
        this.codigo = codigo;
        this.precio = precio;
        this.vuelo = vuelo;
    }
}
