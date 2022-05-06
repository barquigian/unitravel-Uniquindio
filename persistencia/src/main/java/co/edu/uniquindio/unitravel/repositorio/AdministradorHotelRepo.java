package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorHotelRepo extends JpaRepository<AdministradorHotel,String> {

        @Query("select h from Hotel h where h.administradorHotel.codigo=:codigoAdmin")
        List<Hotel> obtenerHotelesAdmin(String codigoAdmin);
        @Query("select h from AdministradorHotel h where h.email=:correo and h.contrasena=:contrasena")
        AdministradorHotel findByEmailAndContrasena(String correo, String contrasena);
        @Query("select a from AdministradorHotel a where a.codigo= :codigoAdministrador")
        AdministradorHotel  obtenerAdministradorHotel(String codigoAdministrador);
}
