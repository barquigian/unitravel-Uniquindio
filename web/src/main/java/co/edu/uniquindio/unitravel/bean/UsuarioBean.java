package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario=new Usuario();
    }
    public void registrarUsuario(){

        try {
            usuarioServicio.registrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
