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
public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private Integer codigo;

    @Column(nullable = false,length = 20)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Usuario> usuarios;
    
    @OneToMany(mappedBy = "ciudadOrigen")
    @ToString.Exclude
    private List<Vuelo> codigoVueloOrigen;

    @OneToMany(mappedBy = "ciudadDestino")
    @ToString.Exclude
    private List<Vuelo> coigoVueloDestino;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Hotel>hoteles;


    public Ciudad(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
