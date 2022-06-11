package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {
    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Value("#{param['fecha_i']}")
    private String fechaInicialParam;

    @Value("#{param['fecha_f']}")
    private String fechaFinalParam;

    @Getter @Setter
    private List<LocalDate> rangoFechas;

    @Getter @Setter
    private List<Hotel> hoteles;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private HotelServicio hotelServicio;

    @PostConstruct
    public void inicializar() {
        hoteles = new ArrayList<>();
        try {
            if (busquedaParam != null && !busquedaParam.isEmpty() && fechaInicialParam != null && !fechaInicialParam.isEmpty() &&
                    fechaFinalParam != null && !fechaFinalParam.isEmpty() ) {

                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                Date fechaInicialDate = sdf.parse(fechaInicialParam);
                Date fechaFinalDate = sdf.parse(fechaFinalParam);

                LocalDateTime fechaInicial = fechaInicialDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                LocalDateTime fechaFinal = fechaFinalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

                hoteles = usuarioServicio.buscarHotelporNombre(busquedaParam);
                List<Hotel> hotelesReserva = hotelServicio.hotelesSinReservaFechasYEnCiudad(fechaInicial,fechaFinal,busqueda);

                if(!hotelesReserva.isEmpty()){
                    hoteles.removeAll(hotelesReserva);
                }

            } else {
                hoteles = usuarioServicio.listarHoteles();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String mirarFechas(){
        if(!rangoFechas.isEmpty()) {
            System.out.println(rangoFechas.get(0));
            System.out.println(rangoFechas.get(1));
        }else {
            System.out.println("Vacia");
        }
        return "#";
    }

    public String buscar(){
        return "resultados_busqueda?faces-redirect=true&amp;busqueda="+busqueda+
                "&amp;fecha_i="+rangoFechas.get(0)+"&amp;fecha_f="+rangoFechas.get(1);
    }
}
