package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelServicioImp {
    public HotelServicioImp(HotelRepo hotelRepo){this.hotelRepo=hotelRepo;}
    @Autowired
    private HotelRepo hotelRepo;

    public Hotel obtenerHotel(Integer codigo) throws Exception{
        return hotelRepo.findById(codigo).orElse(null);
    }
}
