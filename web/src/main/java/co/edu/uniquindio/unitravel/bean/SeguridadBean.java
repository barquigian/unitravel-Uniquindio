package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable{

    @Getter@Setter
    private Persona persona;
    @Getter@Setter
    private String email;
    @Getter@Setter
    private String contrasena;

    @Getter@Setter
    private boolean autenticado;

    @Autowired
    private UnitravelServicio unitravelServicio;

    public String iniciarSesion(){
        try{
            persona = unitravelServicio.validarLogin(email, contrasena);
            autenticado=true;
            return "/index?faces-redirect=true";
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alert", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

}
