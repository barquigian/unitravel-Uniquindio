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
    @ElementCollection
    private List<String> fotoUrl;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Habitacion habitacion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;
}
