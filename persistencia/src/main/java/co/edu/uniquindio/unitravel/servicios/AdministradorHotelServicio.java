package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.AdministradorHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel gestionarLogin(String email, String contrasena)throws Exception;

    Hotel crearHotel(Hotel hotel)throws Exception;

    void elimiarHotel(Integer codigo)throws Exception;

    List<Hotel>listarHoteles(String codigoAdmin)throws Exception;
    void modificarHotel(Hotel hotel)throws Exception;

    AdministradorHotel obtenerAdministradorHotel(String codigo)throws Exception;

    Ciudad obtenerCiudad(Integer codigo) throws Exception;

    List<Ciudad> listarCiudades();

    Caracteristica obtenerCaracteristica(Integer codigo)throws Exception;

    List<Caracteristica> listarCaracteristicas();

    void crearHabitacion(Habitacion habitacion);

    List<Habitacion> listarHabitaciones();

    List<Cama> listarCamas();
}
