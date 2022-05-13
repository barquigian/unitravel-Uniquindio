package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.dto.ComentarioUsuarioDto;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {
    // Inferencia
    List<Usuario> findAllByNombre(String nombre);

    //buscar usuario por medio de un nombre
    @Query("select u from Usuario u where u.nombre= :nombre")

    List<Usuario> buscarporNombre(String nombre);

    //comprueba si es correcto un correo y su contraseña
    @Query("select u from Usuario u where u.email= :correo and u.contrasena= :contrasena")
    Optional<Usuario> comprobarAutenticacion(String correo, String contrasena);

    //inferencia
    Optional<Usuario> findByEmailAndContrasena(String correo, String contrasena);

    //inferencia de busqueda paginada
    Page<Usuario> findAll(Pageable pageable);

    //busca un usuario por medio de su cedula
    @Query("select u from Usuario u where u.cedula= :cedula")
    Usuario buscarporCedula(String cedula);

    //lista la reservas que tenga determinado email
    @Query("select r from Usuario u, IN (u.reservas) r where u.email= :email")
    List<Reserva> obtenerListaReservasPorEmail(String email);

    //lista los comentarios segun los usuarios
   @Query("select u.comentarios,c from Usuario u left join u.comentarios c")
    List<Object[]> obtenerComentarios();

     //lista los comentarios segun los usuarios por DTO
//    List<ComentarioUsuarioDto> obtenerComentariosDto();
    //lista las reservas segun los usuarios
    @Query("select u from Usuario u left join u.reservas r")
    List<Object[]> obtenerReservas();

    //lista los telefonos por usuario
    @Query("select u from Usuario u join u.telefono t where t= :telefono")
    List<Usuario> obtenerUsuarioporTelefono(String telefono);

    //lista los telefonos por usuario sin repetir
    @Query("select distinct t from Usuario u join u.telefono t")
    List<String> obtenerUsuarioPorTelefonoDisnic();


    Optional<Usuario> findByEmail(String correo);

    @Query("select u from Usuario u where u.cedula=:codigo and u.nombre=:nombre and u.email=:email and u.contrasena=:contrasena and u.telefono=:telefonos")
    Usuario crearUsuarioNuevo (String codigo,String nombre,String email,String contrasena,List<String>telefonos);

    @Query("select u from Usuario u where u.cedula=:codigo")
    void eliminarUsuario(String codigo);

}
