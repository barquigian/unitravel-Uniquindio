package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Administrador extends Persona implements Serializable {

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String codigo;

    @OneToMany(mappedBy = "administrador")
    @ToString.Exclude
    private List<AdministradorHotel> administradoresHoteles;


    @OneToMany(mappedBy = "administrador")
    @ToString.Exclude
    private List<Vuelo> vuelos;
   


}
