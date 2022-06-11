package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorio.ComentarioRepo;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.ResponsiveOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Getter @Setter
    private List<String> photos;

    @Getter @Setter
    private List<ResponsiveOption> responsiveOptions1;

    @Getter @Setter
    private List<ResponsiveOption> responsiveOptions2;

    @Getter @Setter
    private List<ResponsiveOption> responsiveOptions3;

    @Getter @Setter
    private int activeIndex = 0;

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
                this.todasLasFotos();
                System.out.println(photos);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Vacio" + codigoHotel);
        }
    }

    public void changeActiveIndex() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.activeIndex = Integer.valueOf(params.get("index"));
    }

    public String photoMin(String url){
        url = url.replace(".jpg","min.jpg");
        return url;
    }

    public void habitacionesNoReservadas(){
        //List<Habitacion> habitacionesReservadas
    }
    public void todasLasFotos(){
        photos = new ArrayList<>();
        List<String> photosHotel = hotelServicio.fotosHotel(hotel.getCodigo());
        List<String> photosHabitacion = new ArrayList<>();
        for (Habitacion habitacion: hotel.getHabitaciones()) {
            List<String> p = hotelServicio.fotosHabitacion(habitacion.getCodigo());
            if(!p.isEmpty()){
                photosHabitacion.addAll(p);
            }
        }
        if(!photosHotel.isEmpty()){
            photos.addAll(photosHotel);
        }
        if(!photosHabitacion.isEmpty()){
            photos.addAll(photosHabitacion);
        }

        responsiveOptions1 = new ArrayList<>();
        responsiveOptions1.add(new ResponsiveOption("1024px", 5));
        responsiveOptions1.add(new ResponsiveOption("768px", 3));
        responsiveOptions1.add(new ResponsiveOption("560px", 1));

        responsiveOptions2 = new ArrayList<>();
        responsiveOptions2.add(new ResponsiveOption("1024px", 5));
        responsiveOptions2.add(new ResponsiveOption("960px", 4));
        responsiveOptions2.add(new ResponsiveOption("768px", 3));
        responsiveOptions2.add(new ResponsiveOption("560px", 1));

        responsiveOptions3 = new ArrayList<>();
        responsiveOptions3.add(new ResponsiveOption("1500px", 5));
        responsiveOptions3.add(new ResponsiveOption("1024px", 3));
        responsiveOptions3.add(new ResponsiveOption("768px", 2));
        responsiveOptions3.add(new ResponsiveOption("560px", 1));

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

    public String irDetalleHotel(String codigoHotel){
        return "detalle_hotel?faces-redirec=true";
    }

}
