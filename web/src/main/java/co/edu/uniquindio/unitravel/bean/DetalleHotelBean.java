package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorio.ComentarioRepo;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {
    @Value("#{param['hotel_id']}")
    private String codigoHotel;

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    private List<Comentario> comentarios;

    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar(){
        nuevoComentario=new Comentario();
        comentarios=new ArrayList<>();
        if(codigoHotel!=null && !codigoHotel.isEmpty()){
            try {
                hotel = hotelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
                comentarios= hotel.getComentarios();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void crearComentario(){
        try {

            nuevoComentario.setHotel(hotel);
            nuevoComentario.setUsuario(usuarioServicio.obtenerUsuario("123243"));
            usuarioServicio.crearComentario(nuevoComentario);
            comentarios.add(nuevoComentario);
            nuevoComentario = new Comentario();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
