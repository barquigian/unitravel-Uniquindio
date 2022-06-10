package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion,String> {

    @Query("select distinct h from Reserva r inner join ReservaHabitacion rh on r.codigo = rh.reserva.codigo " +
            "inner join Habitacion h on rh.habitacion.codigo = h.codigo " +
            "where (r.fechaInicio between :primera and :segunda and  r.fechaFin  between :primera and :segunda)")
    List<Habitacion> habitacionesConReserva(LocalDateTime primera, LocalDateTime segunda);

    @Query("select distinct f.fotoUrl from Habitacion h inner join  Foto f on h.codigo = f.habitacion.codigo where h.codigo = :codigo")
    List<String> urlFotosHabitacion(Integer codigo);

}
