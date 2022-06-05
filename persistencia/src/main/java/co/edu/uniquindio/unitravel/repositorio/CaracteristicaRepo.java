package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaRepo extends JpaRepository<Caracteristica,Integer> {
    @Query("select c from Caracteristica c where c.codigo= :codigo")
    Caracteristica obtenerCaracteristica(Integer codigo);

    @Override
    List<Caracteristica> findAll();
}
