package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepo extends JpaRepository<Caracteristica,String> {
}
