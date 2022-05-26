package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {


    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private List<Hotel> hoteles;
    @PostConstruct
    public void iniciarlizar() {
        hoteles=new ArrayList<>();
        try {
            if (busquedaParam != null && !busquedaParam.isEmpty()) {
                hoteles = usuarioServicio.buscarHotelporNombre(busquedaParam);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public String buscar(){
            return "resultados_busqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }
}
