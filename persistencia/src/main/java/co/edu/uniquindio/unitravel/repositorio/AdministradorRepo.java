package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,String> {

    //inferido. buscar por nombre
    List<Administrador> findAllByNombre(String nombre);

    //buscar por nombre
    @Query("select a from Administrador a where a.nombre like concat('%',:nombre,'%')")
    List<Administrador> buscarporNombre(String nombre);

    //autenticacion de email y contraseña
    @Query("select a from Usuario a where a.email= :email and a.contrasena= :contrasena")
    Optional<Administrador> comprobarAutenticacion(String email, String contrasena);

    //buscar por email y contraseña
    Optional<Administrador> findByEmailAndContrasena(String email, String contrasena);

    //buscar por cedula
    @Query("select a from Administrador a where a.cedula= :cedula")
    Administrador buscarporCedula(String cedula);






}
