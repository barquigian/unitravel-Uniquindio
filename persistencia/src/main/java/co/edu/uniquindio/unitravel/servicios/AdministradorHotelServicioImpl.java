package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
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
        List<Hotel> hotels = listarTodosHoteles();
        Integer codigo = 1;
        if(!hotels.isEmpty()){
            codigo += hotels.get(hotels.size()-1).getCodigo();
        }
        hotel.setCodigo(codigo);
        Hotel buscado = obtenerHotel(hotel.getCodigo());
        if(buscado != null){
            throw new Exception("La cédula del usuario ya está registrada");
        }
         return hotelRepo.save(hotel);

    }

    /**
     * @param codigo
     * @return
     * @throws Exception
     */
    @Override
    public Hotel obtenerHotel(Integer codigo) throws Exception {
        return hotelRepo.findByCodigo(codigo);
    }

    @Override
    public void elimiarHotel(Integer codigo) throws Exception {
        Hotel buscado = obtenerHotel(codigo);
        if (buscado == null){
          throw new Exception();

        }else {
            hotelRepo.delete(buscado);

        }
    }

    /**
     * @param hotels
     * @throws Exception
     */
    @Override
    public void elimiarHoteles(List<Hotel> hotels) throws Exception {
        for(Hotel hotel: hotels){
            Hotel buscado = obtenerHotel(hotel.getCodigo());
            if (buscado == null){
                throw new Exception();

            }else {
                hotelRepo.delete(buscado);

            }
        }
    }

    /**
     * @param hotel
     * @throws Exception
     */
    @Override
    public void actualizarHotel(Hotel hotel) throws Exception {
        Hotel buscado = obtenerHotel(hotel.getCodigo());
        if (buscado == null){
            throw new Exception();

        }else {
            hotelRepo.save(hotel);

        }
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Hotel> listarTodosHoteles() throws Exception {
        return hotelRepo.findAll();
    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) throws Exception {
        return administradorHotelRepo.obtenerHotelesAdmin(codigoAdmin);
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<AdministradorHotel> listarAdminHotel() throws Exception {
        return administradorHotelRepo.findAll();
    }

    /**
     * @param administradorHotel
     * @return
     * @throws Exception
     */
    @Override
    public AdministradorHotel actualizarAdminHotel(AdministradorHotel administradorHotel) throws Exception {
        AdministradorHotel buscado = obtenerAdministradorHotel(administradorHotel.getCedula());
        if (buscado == null) {
            throw new Exception("El usuario no existe");
        }
        return administradorHotelRepo.save(administradorHotel);
    }

    /**
     * @param administradorHotel
     * @return
     * @throws Exception
     */
    @Override
    public AdministradorHotel registrarAdminHotel(AdministradorHotel administradorHotel) throws Exception {
        AdministradorHotel buscado = obtenerAdministradorHotel(administradorHotel.getCedula());
        //Usuario usuarioEmail= bus
        if (buscado != null) {
            throw new Exception("La cédula del usuario ya está registrada");
        }
        if(buscado!=null){

        }
        return administradorHotelRepo.save(administradorHotel);
    }

    /**
     * @param cedula
     * @throws Exception
     */
    @Override
    public void eliminarAdminHotel(String cedula) throws Exception {
        AdministradorHotel buscado = obtenerAdministradorHotel(cedula);

        if (buscado == null) {
            throw new Exception("El usuario no existe");
        }
        administradorHotelRepo.delete(buscado);
    }

    /**
     * @param administradorHotels
     * @throws Exception
     */
    @Override
    public void eliminarAdminHotels(List<AdministradorHotel> administradorHotels) throws Exception {
        for(AdministradorHotel administradorHotel: administradorHotels){
            AdministradorHotel buscado = obtenerAdministradorHotel(administradorHotel.getCedula());

            if (buscado == null) {
                throw new Exception("El usuario no existe");
            }
            administradorHotelRepo.delete(buscado);
        }
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
