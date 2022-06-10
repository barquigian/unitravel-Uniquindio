package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;

import java.util.List;

public interface CiudadServicio {

    Ciudad registrarCiudad(Ciudad c) throws Exception;
    Ciudad obtenerCiudad(Integer codigo)throws Exception;
    Ciudad actualizarCiudad(Ciudad c)throws Exception;
    List<Ciudad> listarCiudades();
    void elimiarCiudad(Integer codigo)throws Exception;
    void elimiarCiudades(List<Ciudad> CiudadList)throws Exception;

}
