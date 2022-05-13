package co.edu.uniquindio.unitravel.entidades;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
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
public class Cama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private Integer codigo;

    @Column(nullable = false)
    private Integer tipo;

    @ManyToMany(mappedBy = "camas")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

}

