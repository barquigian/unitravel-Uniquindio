package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface HotelServicio {

    Hotel obtenerHotel(Integer codigo)throws Exception;

    List<Hotel> hotelesSinReservaFechasYEnCiudad(LocalDateTime primera, LocalDateTime segunda, String ciudad);

    List<Habitacion> habitacionesSinReservayDeHotel(LocalDateTime primera, LocalDateTime segunda, Integer codigo_hotel);
}

