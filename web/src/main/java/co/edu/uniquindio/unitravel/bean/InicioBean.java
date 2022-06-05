package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar(){
        hoteles= usuarioServicio.listarHoteles();
        ciudades= usuarioServicio.listarCiudades();
    }
    public String irRegistro(){
        return "registrar_usuario?faces-redirec=true";
    }
    public String irLogin(){return "login?faces-redirec=true";}

}