package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    @Override
    public Administrador gestionarLogin(String email, String contrasena) throws Exception {
        return null;
    }

    @Override
    public AdministradorHotel registrarAdministradorHotel(Administrador admin) throws Exception {
        return null;
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo) throws Exception {
        return null;
    }

    @Override
    public Vuelo modificarVuelo(String codigoVuelo) throws Exception {
        return null;
    }

    @Override
    public void elimiarVuelo(String cedula) throws Exception {

    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {
        return null;
    }

    @Override
    public Ciudad modificarCiudad(String codigoVuelo) throws Exception {
        return null;
    }

    @Override
    public void elimiarCiudad(String cedula) throws Exception {

    }
}
