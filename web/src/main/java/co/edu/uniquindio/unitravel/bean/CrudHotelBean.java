package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.CiudadRepo;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedEvent
@Component
@ViewScoped
@Configuration
public class CrudHotelBean implements Serializable {

    private List<Hotel> hotels;

    private Hotel selectedHotel;

    private List<Hotel> selectedHotels;

    private List<Ciudad> ciudades;

    private List<AdministradorHotel> administradorHotels;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private CiudadServicio ciudadServicio;


    @PostConstruct
    public void init() throws Exception {
        this.selectedHotels = new ArrayList<>();
        this.selectedHotel = new Hotel();
        this.hotels = administradorHotelServicio.listarTodosHoteles();
        this.ciudades = ciudadServicio.listarCiudades();
        this.administradorHotels = administradorHotelServicio.listarAdminHotel();
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

    public List<Hotel> getSelectedHotels() {
        return selectedHotels;
    }

    public void setSelectedHotels(List<Hotel> selectedHotels) {
        this.selectedHotels = selectedHotels;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<AdministradorHotel> getAdministradorHotels() {
        return administradorHotels;
    }

    public void setAdministradorHotels(List<AdministradorHotel> administradorHotels) {
        this.administradorHotels = administradorHotels;
    }

    public void openNew() {
        this.selectedHotel = new Hotel();
    }

    public void saveProduct() {

        try {
            this.administradorHotelServicio.actualizarHotel(this.selectedHotel);
            this.hotels = administradorHotelServicio.listarTodosHoteles();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel actualizado"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El hotel no existe"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void saveNewProduct() {
        try {
            this.administradorHotelServicio.crearHotel(this.selectedHotel);
            this.hotels = administradorHotelServicio.listarTodosHoteles();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel añadido"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        try {
            this.administradorHotelServicio.elimiarHotel(this.selectedHotel.getCodigo());
            this.hotels = administradorHotelServicio.listarTodosHoteles();
            this.selectedHotel = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El hotal no existe"));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hotel eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedHotels.size();
            return size > 1 ? size + " hoteles seleccionados" : "1 hotel selecionado";
        }

        return "Eliminar";
    }

    public boolean hasSelectedProducts() {
        return this.selectedHotels != null && !this.selectedHotels.isEmpty();
    }

    public void deleteSelectedProducts() {
        try {
            this.administradorHotelServicio.elimiarHoteles(this.selectedHotels);
            this.hotels = administradorHotelServicio.listarTodosHoteles();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uno de los usuarios no pudo ser elmiminado"));
        }
        this.selectedHotels = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuarios eliminados"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}
