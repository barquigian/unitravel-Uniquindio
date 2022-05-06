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
public class Vuelo implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;
    @Column(nullable = false,length = 10)
    private float precio;

    @ManyToOne
    private Ciudad ciudadOrigen;
    @ManyToOne
    private Ciudad ciudadDestino;

    @Column(nullable = false)
    private Integer numeroSillas;

    @Column(nullable = false,length = 100)
    private String estado;

    @Column(nullable = false,length = 10)
    private String aerolinea;

    @ManyToMany
    @ToString.Exclude
    private List<Silla> sillas;

    @ManyToOne
    @ToString.Exclude
    private Administrador administrador;


}
