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
public class Foto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;
    @Column(nullable = false,length = 50)
    private String fotoUrl;
    
    @ManyToOne
    private Habitacion habitacion;

    @ManyToOne
    private Hotel hotel;

    public Foto(String codigo, Habitacion habitacion, Hotel hotel) {
        this.codigo = codigo;
        this.habitacion = habitacion;
    }
}
