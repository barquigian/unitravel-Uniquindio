package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;

    @Column(nullable = false,length = 100)
    private String comentario;

    @Positive
    @Column(nullable = false)
    private Integer calificacion;

    @Column(nullable = false)
    private LocalDateTime fechaCalificacion;
   
    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    public Comentario(String codigo, String comentario, int calificacion, Hotel hotel, Usuario usuario) {
        this.codigo=codigo;
        this.comentario=comentario;
        this.calificacion=calificacion;
        this.fechaCalificacion= LocalDateTime.now();
        this.hotel=hotel;
        this.usuario=usuario;
    }


}
