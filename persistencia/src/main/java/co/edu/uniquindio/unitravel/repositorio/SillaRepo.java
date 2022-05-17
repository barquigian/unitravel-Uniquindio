package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SillaRepo extends JpaRepository<Silla,String> {

    @Query("select s.estado from Reserva s join s.reservaSillas")
    String obtenerEstadoSilla();


}
