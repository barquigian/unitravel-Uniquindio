package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(nullable = false)
    private Administrador administrador;

    @OneToMany(mappedBy = "administradorHotel")
    @ToString.Exclude
    private List<Hotel> hoteles;

    public AdministradorHotel(String codigo, String cedula, String nombre, @Email String email, String contrasena,String cedulaAdministrador) {
        super(cedula, nombre, email, contrasena);
        this.codigo = codigo;

    }

    public AdministradorHotel(String codigo) {
        this.codigo = codigo;
    }
}
