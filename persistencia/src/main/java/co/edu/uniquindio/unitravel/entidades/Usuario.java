package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {
    @ElementCollection
    @ToString.Include
    @Column(nullable = true,length = 15)
    private List<String>telefono;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;
    
    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Reserva> reservas;

    public Usuario(String cedula, String nombre, @Email String email, String contrasena) {
        super(cedula, nombre, email, contrasena);
    }

    public Usuario(String cedula, String nombre, @Email String email, String contrasena, List<String> telefono) {
        super(cedula, nombre, email, contrasena);
        this.telefono = telefono;
    }
}
