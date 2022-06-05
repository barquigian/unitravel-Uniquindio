package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio{
    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private CaracteristicaRepo caracteristicaRepo;
    @Autowired
    private HabitacionRepo habitacionRepo;

    @Override
    public AdministradorHotel gestionarLogin(String email, String contrasena) throws Exception {
        AdministradorHotel administradorHotel= administradorHotelRepo.findByEmailAndContrasena(email,contrasena);
        return administradorHotel;
    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {


         return hotelRepo.save(hotel);

    }

    @Override
    public void elimiarHotel(Integer codigo) throws Exception {
        Optional<Hotel> hotel= hotelRepo.findById(codigo);
        if (hotel.isEmpty()){
          throw new Exception();

        }else {
            hotelRepo.delete(hotel.get());

        }
    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) throws Exception {
        return administradorHotelRepo.obtenerHotelesAdmin(codigoAdmin);
    }

    @Override
    public void modificarHotel(Hotel hotel) throws Exception {
        hotel.setDireccion("Cra 20a #83");
        hotelRepo.save(hotel);

            if (hotel.getCodigo()==null) {
                throw new Exception();

            } else{
                hotelRepo.save(hotel);
            }

    }

    @Override
    public AdministradorHotel obtenerAdministradorHotel(String codigo) throws Exception {
        return administradorHotelRepo.findById(codigo).orElse(null);
    }



    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {

        return  ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Caracteristica obtenerCaracteristica(Integer codigo) throws Exception {
        try {
            Caracteristica caracteristica = caracteristicaRepo.obtenerCaracteristica(1);
            return caracteristica;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Caracteristica> listarCaracteristicas() {
        return caracteristicaRepo.findAll();
    }

    @Override
    public void crearHabitacion(Habitacion habitacion) {

            habitacionRepo.save(habitacion);
    }

    @Override
    public List<Habitacion> listarHabitaciones() {

        return administradorHotelRepo.listarHabitaciones();
    }

    @Override
    public List<Cama> listarCamas() {
        return administradorHotelRepo.listarCamas();
    }

}
