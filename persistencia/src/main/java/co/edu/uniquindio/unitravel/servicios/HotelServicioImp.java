package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.HabitacionRepo;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServicioImp  implements HotelServicio{
    public HotelServicioImp(HotelRepo hotelRepo, HabitacionRepo habitacionRepo){
        this.hotelRepo=hotelRepo;
        this.habitacionRepo = habitacionRepo;
    }
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private HabitacionRepo habitacionRepo;

    public Hotel obtenerHotel(Integer codigo){

           return hotelRepo.findById(codigo).orElse(null);
    }

    /**
     * @param primera
     * @param segunda
     * @param ciudad
     * @return
     */
    @Override
    public List<Hotel> hotelesSinReservaFechasYEnCiudad(LocalDateTime primera, LocalDateTime segunda, String ciudad) {
        return hotelRepo.hotelesSinReservaFechasYEnCiudad(primera,segunda,ciudad);
    }

    /**
     * @param primera
     * @param segunda
     * @param codigo_hotel
     * @return
     */
    @Override
    public List<Habitacion> habitacionesSinReservayDeHotel(LocalDateTime primera, LocalDateTime segunda, Integer codigo_hotel) {
        return habitacionRepo.habitacionesSinReservayDeHotel(primera,segunda,codigo_hotel);
    }

    /**
     * @param codigo
     * @return
     */
    @Override
    public List<String> fotosHotel(Integer codigo) {
            List<String> fotos = hotelRepo.urlFotosHotel(codigo);
            if(!fotos.isEmpty()){
                return fotos;
            }
        return new ArrayList<>();
    }

    /**
     * @param codigo
     * @return
     */
    @Override
    public List<String> fotosHabitacion(Integer codigo) {
        List<String> fotos = habitacionRepo.urlFotosHabitacion(codigo);
        if(!fotos.isEmpty()){
            return fotos;
        }
        return new ArrayList<>();
    }


}
