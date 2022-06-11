package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UnitravelServicioImpl implements UnitravelServicio {

    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;
    @Autowired
    private AdministradorRepo administradorRepo;
    @Autowired
    private CaracteristicaRepo caracteristicaRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private ComentarioRepo comentarioRepo;

    public UnitravelServicioImpl(CiudadRepo ciudadRepo,
                                 UsuarioRepo usuarioRepo,
                                 AdministradorHotelRepo administradorHotelRepo,
                                 AdministradorRepo administradorRepo,
                                 CaracteristicaRepo caracteristicaRepo,
                                 HotelRepo hotelRepo,
                                 ComentarioRepo comentarioRepo) {
        this.ciudadRepo = ciudadRepo;
        this.usuarioRepo = usuarioRepo;
        this.administradorHotelRepo = administradorHotelRepo;
        this.administradorRepo = administradorRepo;
        this.caracteristicaRepo = caracteristicaRepo;
        this.hotelRepo = hotelRepo;
        this.comentarioRepo = comentarioRepo;
    }

    @Override
    public Persona validarLogin(String correo, String contrasena) throws Exception{

        Persona usuario = usuarioRepo.findByEmailAndContrasena(correo, contrasena).orElse(null);

        if(usuario==null){
            usuario=administradorHotelRepo.findByEmailAndContrasena(correo, contrasena);
        }

        if (usuario==null){
            usuario = administradorRepo.findByEmailAndContrasena(correo, contrasena).orElse(null);
        }

        if (usuario==null){
            throw new Exception("Los datos de autenticación con incorrectos");
        }
        return usuario;
    }





    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception{
        return ciudadRepo.findById(codigo).orElse(null);
    }



}
