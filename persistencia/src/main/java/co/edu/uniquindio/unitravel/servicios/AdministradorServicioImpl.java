package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    @Autowired
    private AdministradorRepo administradorRepo;

    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;

    @Autowired
    private VueloRepo vueloRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private ReservaRepo reservaRepo;

    @Override
    public Administrador gestionarLogin(String email, String contrasena) throws Exception {
        Optional<Administrador> administrador =administradorRepo.findByEmailAndContrasena(email, contrasena);
        if (administrador.isEmpty()) {
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        return administrador.get();
    }

    @Override
    public AdministradorHotel registrarAdministradorHotel(AdministradorHotel admin) throws Exception {
        AdministradorHotel adminguardar= administradorHotelRepo.save(admin);
        return adminguardar;
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo) throws Exception {

        Vuelo vueloGuardado= vueloRepo.save(vuelo);
        return vueloGuardado;
    }

    @Override
    public Vuelo modificarVuelo(String codigoVuelo) throws Exception {

        Vuelo vuelo= vueloRepo.getById(codigoVuelo);
        vuelo.setAerolinea("sdafw24");
        vueloRepo.save(vuelo);
        return vuelo;
    }

    @Override
    public void elimiarVuelo(String codigo) throws Exception {
            Vuelo vuelo= vueloRepo.getById(codigo);
            if (vuelo.getCodigo().equals(codigo)){
                vueloRepo.delete(vuelo);
            }throw new Exception();
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {
        Ciudad ciudadguardado= ciudadRepo.save(ciudad);

        return ciudadguardado;
    }

    @Override
    public Ciudad modificarCiudad(Integer codigo) throws Exception {

        Ciudad ciudad=ciudadRepo.findById(codigo).get();
        ciudad.setNombre("cartagena");
        ciudadRepo.save(ciudad);
        return ciudad;
    }

    @Override
    public void elimiarCiudad(Integer cedula) throws Exception {
        Ciudad ciudad = ciudadRepo.findById(cedula).get();
        if (ciudad.getCodigo() == cedula) {
            ciudadRepo.delete(ciudad);
        } else {
            throw new Exception();
        }
    }
}
