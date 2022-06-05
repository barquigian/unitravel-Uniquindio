package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class InicioBean implements Serializable {
    private String mensaje = "UniTravel";

    @Getter @Setter
    private List<Hotel> hoteles;

    @Autowired
    private UsuarioServicio usuarioServicio;

    public void inicializar(){
        hoteles= usuarioServicio.listarHoteles();
    }
    public String irRegistro(){
        return "registrar_usuario?faces-redirec=true";
    }

}