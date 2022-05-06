package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Persona implements Serializable {
    @EqualsAndHashCode.Include
    private String codigo;

    @OneToMany(mappedBy = "administradorHotel")
    @ToString.Exclude
    private List<Hotel> hoteles;




}
