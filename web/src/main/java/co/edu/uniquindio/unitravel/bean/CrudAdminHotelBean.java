package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
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
public class CrudAdminHotelBean implements Serializable {

    @Getter
    @Setter
    private List<AdministradorHotel> administradorHotels;

    @Getter
    @Setter
    private AdministradorHotel selectedadministradorHotel;

    @Getter
    @Setter
    private List<AdministradorHotel> selectedadministradorHotels;

    @Getter
    @Setter
    private List<Ciudad> ciudades;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() throws Exception {
        this.administradorHotels = new ArrayList<>();
        this.selectedadministradorHotels = new ArrayList<>();
        this.selectedadministradorHotel = new AdministradorHotel();
        this.administradorHotels = administradorHotelServicio.listarAdminHotel();
        this.ciudades= usuarioServicio.listarCiudades();
    }

    public void openNew() {
        this.selectedadministradorHotel = new AdministradorHotel();
    }

    public void saveProduct() {

        try {
            this.administradorHotelServicio.actualizarAdminHotel(this.selectedadministradorHotel);
            this.administradorHotels = administradorHotelServicio.listarAdminHotel();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin Hotel actualizado"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La cedula no existe"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void saveNewProduct() {
        try {
            this.selectedadministradorHotel.setContrasena("12345");
            this.administradorHotelServicio.registrarAdminHotel(this.selectedadministradorHotel);
            this.administradorHotels = administradorHotelServicio.listarAdminHotel();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin Hotel añadido"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        try {
            this.administradorHotelServicio.eliminarAdminHotel(this.selectedadministradorHotel.getCedula());
            this.administradorHotels = administradorHotelServicio.listarAdminHotel();
            this.selectedadministradorHotel = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin Hotel eliminado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La cedula no existe"));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedadministradorHotels.size();
            return size > 1 ? size + " admin hoteles seleccionados" : "1 admin hotel selecionado";
        }

        return "Eliminar";
    }

    public boolean hasSelectedProducts() {
        return this.selectedadministradorHotels != null && !this.selectedadministradorHotels.isEmpty();
    }

    public void deleteSelectedProducts() {
        try {
            this.administradorHotelServicio.eliminarAdminHotels(this.selectedadministradorHotels);
            this.administradorHotels = administradorHotelServicio.listarAdminHotel();
            this.selectedadministradorHotels = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Admin Hotel eliminados"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uno de los Admin Hotel no pudo ser elmiminado"));
        }
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}
