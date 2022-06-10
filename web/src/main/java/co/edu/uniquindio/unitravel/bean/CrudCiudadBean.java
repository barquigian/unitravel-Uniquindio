package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.CiudadServicio;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@NamedEvent
@Component
@ViewScoped
@Configuration
public class CrudCiudadBean {

    private List<Ciudad> ciudades;

    private Ciudad selectedCiudad;

    private List<Ciudad> selectedCiudades;


    @Autowired
    private CiudadServicio ciudadServicio;

    @PostConstruct
    public void init() {
        this.ciudades = new ArrayList<>();
        this.selectedCiudades = new ArrayList<>();
        this.selectedCiudad = new Ciudad();
        this.ciudades = ciudadServicio.listarCiudades();
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public Ciudad getSelectedCiudad() {
        return selectedCiudad;
    }

    public void setSelectedCiudad(Ciudad selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    public List<Ciudad> getSelectedCiudades() {
        return selectedCiudades;
    }

    public void setSelectedCiudades(List<Ciudad> selectedCiudades) {
        this.selectedCiudades = selectedCiudades;
    }

    public void openNew() {
        this.selectedCiudad = new Ciudad();
    }

    public void saveProduct() {

        try {
            this.ciudadServicio.actualizarCiudad(this.selectedCiudad);
            this.ciudades = this.ciudadServicio.listarCiudades();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ciudad actualizada"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La ciudad no existe"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void saveNewProduct() {
        try {
            int codigo = ciudades.get(ciudades.size() - 1).getCodigo();
            this.selectedCiudad.setCodigo(codigo + 1);
            this.ciudadServicio.registrarCiudad(this.selectedCiudad);
            this.ciudades = this.ciudadServicio.listarCiudades();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ciudad añadidida"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        try {
            this.ciudadServicio.elimiarCiudad(this.selectedCiudad.getCodigo());
            this.ciudades = this.ciudadServicio.listarCiudades();
            this.selectedCiudad = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La ciudad no existe"));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ciudad eliminada"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedCiudades.size();
            return size > 1 ? size + " ciudades seleccionadas" : "1 ciudad selecionada";
        }

        return "Eliminar";
    }

    public boolean hasSelectedProducts() {
        return this.selectedCiudades != null && !this.selectedCiudades.isEmpty();
    }

    public void deleteSelectedProducts() {
        try {
            this.ciudadServicio.elimiarCiudades(this.selectedCiudades);
            this.ciudades = this.ciudadServicio.listarCiudades();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uno de los usuarios no pudo ser elmiminado"));
        }
        this.selectedCiudades = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuarios eliminados"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}
