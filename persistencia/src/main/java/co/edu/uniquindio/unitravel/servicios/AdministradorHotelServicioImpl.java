package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorio.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
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
            JOptionPane.showMessageDialog(null,"no existe el hotel con este codigo");

        }else {
            hotelRepo.delete(hotel.get());
            JOptionPane.showMessageDialog(null,"el hotel fue eliminado con exito");
        }
    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) throws Exception {
        return administradorHotelRepo.obtenerHotelesAdmin(codigoAdmin);
    }

    @Override
    public Hotel modificarHotel(int codigoAntiguo, int codigo, String nombre, String direccion, String telefono, int numeroEstrellas, AdministradorHotel administradorHotel, Ciudad ciudad) throws Exception {
        Optional<Hotel>hotel1= hotelRepo.findById(codigoAntiguo);
        if (hotel1.isEmpty()){
            JOptionPane.showMessageDialog(null,"no existe el hotel con este codigo");
        }else {
            ;
            hotelRepo.save(new Hotel(codigo,nombre,direccion,telefono,numeroEstrellas,administradorHotel,ciudad));
        }
        return hotelRepo.save(hotel1.get());
    }

    @Override
    public Hotel obtenerHotel(Integer codigo) throws Exception {
        Optional<Hotel> hotel= hotelRepo.findById(codigo);

            return hotel.get();

    }
}
