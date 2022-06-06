package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServicioImp  implements HotelServicio{
    public HotelServicioImp(HotelRepo hotelRepo){this.hotelRepo=hotelRepo;}
    @Autowired
    private HotelRepo hotelRepo;

    public Hotel obtenerHotel(Integer codigo){

           return hotelRepo.findById(codigo).orElse(null);
    }
}
