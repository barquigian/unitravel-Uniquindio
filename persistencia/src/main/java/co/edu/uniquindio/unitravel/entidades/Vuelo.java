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
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false)
    private Integer numeroSillas;

    @Column(nullable = false,length = 100)
    private String estado;

    @Column(nullable = false,length = 10)
    private String aerolinea;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadOrigen;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadDestino;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Administrador administrador;

    @ManyToMany
    @ToString.Exclude
    private List<Silla> sillas;

    


}
