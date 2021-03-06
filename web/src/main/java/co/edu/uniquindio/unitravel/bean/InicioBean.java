package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {
    private String mensaje = "UniTravel";

    @Getter @Setter
    private List<Hotel> hoteles;
    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Hotel selectedHotel;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @PostConstruct
    public void inicializar(){
        hoteles= usuarioServicio.listarHoteles();
        ciudades= usuarioServicio.listarCiudades();
        selectedHotel = new Hotel();
    }
    public String irRegistro(){
        return "registrar_usuario?faces-redirec=true";
    }
    public String irLogin(){return "login?faces-redirec=true";}

    public String irDetalleHotel(){
        System.out.println(selectedHotel.getNombre());
        return "detalle_hotel?faces-redirec=true&amp;hotel_id="+selectedHotel.getCodigo().toString();
    }
    public String irDetalleHotel(String codigoHotel){
        return "detalle_hotel?faces-redirec=true&amp;hotel_id="+codigoHotel;
    }



}