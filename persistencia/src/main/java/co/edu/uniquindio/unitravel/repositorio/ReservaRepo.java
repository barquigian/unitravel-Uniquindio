package co.edu.uniquindio.unitravel.repositorio;
import co.edu.uniquindio.unitravel.dto.ReservaDto;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository <Reserva,String>  {
    //obtiene las reservas segun el codigo y la fecha
    @Query("select r.usuario.nombre,r.fechaReserva,h.habitacion from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo= :idHotel and r.fechaInicio< :fecha")
    List<Object[]> obtenerReservasPorHabitacines(Integer idHotel, LocalDateTime fecha);

    //obtiene las reservas segun el codigo y la fecha DTO
    @Query("select new co.edu.uniquindio.unitravel.dto.ReservaDto(r.usuario.nombre,r.fechaReserva,h.habitacion) from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo= :idHotel and r.fechaInicio< :fecha")
    List<ReservaDto> obtenerReservasPorHabitacinesDto(Integer idHotel, LocalDateTime fecha);

    //obtiene el numero de reservas de un hotel
    @Query("select count(r) from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo= :codigoHotel and r.fechaInicio> current_date ")
    int ObtenerNumeroReservas(Integer codigoHotel);

    //obtiene el valor de la reservas segun el codigo
    @Query("select r.codigo,(select sum(rh.precio) from ReservaHabitacion rh where rh.habitacion= r group by r),(select sum(rs.precio) from ReservaSilla rs where rs.reserva= r group by r) from Reserva r where r.usuario.cedula= :codigoUsuario")
    List<Object[]> obtenerValorReserva(String codigoUsuario);

    //obtiene las reservas segun el codigo
    @Query("select r.codigo,rh,rs from Reserva r join r.reservaHabitaciones rh left join r.reservaSillas rs where r.usuario.cedula= :codigoUsuario")
    List<Object[]> listaReservaUsuaro(String codigoUsuario);
    @Query("select r from Reserva r where r.codigo=:codigoReserva")
    Reserva  modificarReserva(String codigoReserva);

    @Query("select r from Reserva r join r.reservaHabitaciones h left join r.reservaSillas s where r.codigo=:codigo")
    List<Object[]> obtenerReservayHabitacionPorCedula(String codigo);

    @Query("select r from Reserva r where r.usuario.cedula=:codigo")
    Reserva obtenerReservaPorCedula(String codigo);

    @Query("select count(r) from Reserva r join r.reservaHabitaciones h where h.habitacion.codigo=:codigoHotel and r.fechaInicio= current_date ")
    int obtenerNumeroResevas(Integer codigoHotel);

    //retorna el codigo de la reserva, precio total habitaciones y precio total sillas
    @Query("select r.codigo,(select sum(rh.precio)from ReservaHabitacion rh where rh.habitacion=r group by r),(select sum(rs.precio) from ReservaSilla rs where rs.silla=r group by r) from Reserva r where r.usuario.cedula=:codigoUsuario")
    List<Object[]> obtenerTotalPorReserva(String codigoUsuario);

    @Query("select rs.silla.vuelo, sum(rs.reserva.cantidadPersonas) from ReservaSilla rs group by rs.silla.vuelo")
    List<Object[]> vuelosMasApetecidos();
}
