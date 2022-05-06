package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,String> {
}
