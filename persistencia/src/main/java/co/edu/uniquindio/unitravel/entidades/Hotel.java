package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
public class Hotel implements Serializable {
    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 25)
    private String nombre;

    @Column(nullable = false, length = 25)
    private String direccion;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, length = 20)
    private Integer numEstrellas;

    @Lob
    private String descripcion;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AdministradorHotel administradorHotel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Foto> fotos;


   /*@ElementCollection
   @LazyCollection(LazyCollectionOption.FALSE)
    private List<String>fotos;*/

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica>caracteristicas;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany
    @ToString.Exclude
    private List<Reserva> reservas;


    public Hotel(Integer codigo, String nombre, String direccion, String telefono, Integer numEstrellas, AdministradorHotel administradorHotel, Ciudad ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numEstrellas = numEstrellas;
        this.administradorHotel = administradorHotel;
        this.ciudad = ciudad;
    }

    public Hotel(Integer codigo, String nombre, String direccion, String telefono, Integer numEstrellas, AdministradorHotel administradorHotel,
                 Ciudad ciudad, List<Habitacion> habitaciones, List<Foto> fotos, List<Caracteristica> caracteristicas, List<Comentario> comentarios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numEstrellas = numEstrellas;
        this.administradorHotel = administradorHotel;
        this.ciudad = ciudad;
        this.habitaciones = habitaciones;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.comentarios = comentarios;
    }
    public String getImagenPrincipal(){

       /* if(fotos!=null){
            if(fotos.isEmpty()){
                return fotos.get(0);
            }
        }*/
        return "default.png";
    }
}
