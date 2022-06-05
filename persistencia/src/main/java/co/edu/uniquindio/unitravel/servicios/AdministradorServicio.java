package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AdministradorServicio {

    Administrador gestionarLogin(String email, String contrasena)throws Exception;
    AdministradorHotel registrarAdministradorHotel(AdministradorHotel admin)throws Exception;
    Vuelo crearVuelo(Vuelo vuelo)throws Exception;
    Vuelo modificarVuelo(String codigoVuelo)throws Exception;
    void elimiarVuelo(String codigo)throws Exception;
    Ciudad crearCiudad(Ciudad ciudad)throws Exception;
    Ciudad modificarCiudad(Integer codigo)throws Exception;
    void elimiarCiudad(Integer cedula)throws Exception;
    Caracteristica obtenerCaracteristica(Integer codigo)throws Exception;
    List<Caracteristica> listarCaracteristicas();
}
