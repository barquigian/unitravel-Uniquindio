package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;
    Usuario obtenerUsuario(String codigo)throws Exception;
    Usuario actualizarUsuario(Usuario u)throws Exception;
    List<Usuario> listarUsuario();
    List<Reserva> listarReservas(String codigo)throws Exception;
    void elimiarUsuario(String cedula)throws Exception;
    void elimiarUsuarios(List<Usuario> usuarioList)throws Exception;
    Usuario validarLogin(String correo,String contrasena)throws Exception;
    Comentario crearComentario(Comentario comentario)throws Exception;
    Reserva hacerReserva(Reserva reserva)throws Exception;
    List<Hotel> buscarHotelPorCiudad(Integer codigoCiudad)throws Exception;
    void eliminarReserva (String codigo)throws Exception;
    Reserva modificarReserva(Reserva reserva)throws  Exception;
    void recuperarContrase├▒a(String email)throws Exception;
    void cambiarEstadoDeHabitacion(Habitacion habitacion,String estado)throws Exception;
    void eliminarUsuario(String codigo);
    double consultarPrecioReserva(String codigoReserva)throws Exception;
    double consultarPrecioReservaMasIva(String codigoReserva)throws Exception;
    boolean verificarDisponibilidadFecha(Reserva reserva);
    List<Hotel> buscarHotelporNombre(String nombreHotel);
    List<Ciudad> listarCiudades();
    Ciudad obtenerCiudad(Integer codigo);
    List<Hotel> listarHoteles();

}
