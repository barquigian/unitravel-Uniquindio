package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
@Component
@ViewScoped
public class HotelBean implements Serializable {
    @Getter @Setter
    private Hotel hotel;

    @Autowired
    AdministradorHotelServicio administradorHotelServicio;

    @PostConstruct
    public void iniciarlizar(){
        hotel=new Hotel();
    }
    public void registrarHotel(){
        try {

            Ciudad ciudad=administradorHotelServicio.obtenerCiudad(1);
            AdministradorHotel administradorHotel=administradorHotelServicio.obtenerAdministradorHotel("1");
            hotel.setCiudad(ciudad);
            hotel.setAdministradorHotel(administradorHotel);
            administradorHotelServicio.crearHotel(hotel);
            FacesMessage ms= new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta","hotel creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null,ms);
        } catch (Exception e) {
            FacesMessage ms= new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,ms);
        }
    }
}
