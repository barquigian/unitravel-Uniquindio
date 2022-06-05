package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
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
public class CrudUsuarioBean implements Serializable {

    private List<Usuario> usuarios;

    private Usuario selectedUsuario;

    private List<Usuario> selectedUsuarios;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        this.usuarios = new ArrayList<>();
        this.selectedUsuarios = new ArrayList<>();
        this.selectedUsuario = new Usuario();
        this.usuarios = usuarioServicio.listarUsuario();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public List<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public void openNew() {
        this.selectedUsuario = new Usuario();
    }

    public void saveProduct() {
        if (this.selectedUsuario.getCiudad() == null) {
            this.selectedUsuario.setContrasena(selectedUsuario.getEmail());
            try {
                this.usuarioServicio.registrarUsuario(this.selectedUsuario);
                this.usuarios = this.usuarioServicio.listarUsuario();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario añadido"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La cedula ya existe"));
            }

        }
        else {
            try {
                this.usuarioServicio.actualizarUsuario(this.selectedUsuario);
                this.usuarios = this.usuarioServicio.listarUsuario();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario actualizado"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La cedula no existe"));
            }
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        try {
            this.usuarioServicio.elimiarUsuario(this.selectedUsuario.getCedula());
            this.usuarios = this.usuarioServicio.listarUsuario();
            this.selectedUsuario = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La cedula no existe"));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedUsuarios.size();
            return size > 1 ? size + " usuarios seleccionados" : "1 usuario selecionado";
        }

        return "Eliminar";
    }

    public boolean hasSelectedProducts() {
        return this.selectedUsuarios != null && !this.selectedUsuarios.isEmpty();
    }

    public void deleteSelectedProducts() {
        try {
            this.usuarioServicio.elimiarUsuarios(this.selectedUsuarios);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uno de los usuarios no pudo ser elmiminado"));
        }
        this.selectedUsuarios = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuarios eliminados"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}
