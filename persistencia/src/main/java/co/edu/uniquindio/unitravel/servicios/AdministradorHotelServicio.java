package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorio.AdministradorHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel gestionarLogin(String email, String contrasena)throws Exception;

    Hotel crearHotel(Hotel hotel)throws Exception;

    void elimiarHotel(Integer codigo)throws Exception;

    List<Hotel>listarHoteles(String codigoAdmin)throws Exception;
    void modificarHotel(Hotel hotel)throws Exception;

    AdministradorHotel obtenerAdministradorHotel(String codigo)throws Exception;

    Ciudad obtenerCiudad(Integer codigo) throws Exception;
}
