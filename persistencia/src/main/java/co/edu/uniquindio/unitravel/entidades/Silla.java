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
    private double precio;
    
    @OneToMany(mappedBy = "silla")
    @ToString.Exclude
    private List<ReservaSilla> reservaSillas;

    @ManyToMany(mappedBy = "sillas")
    @ToString.Exclude
    private List<Vuelo> vuelos;

    public Silla(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;

    }

    public Silla(String codigo, double precio, List<Vuelo> vuelos) {
        this.codigo = codigo;
        this.precio = precio;
        this.vuelos = vuelos;
    }
    public Silla(String codigo,double precio, String codigoVuelo){
        this.codigo=codigo;
        this.precio=precio;
    }
}
