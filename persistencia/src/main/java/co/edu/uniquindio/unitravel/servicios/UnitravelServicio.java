package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Persona;

import java.util.List;

public interface UnitravelServicio {
    Persona validarLogin(String correo, String contrasena) throws Exception;

    Ciudad obtenerCiudad(Integer codigo) throws Exception;


}
