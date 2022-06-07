package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HotelBean implements Serializable {
    @Getter @Setter
    private Hotel hotel;

    @Value("$(upload.url)")
    private String urlImagenes;

    @Getter @Setter
    private ArrayList<String> imagenes;

    @Autowired
    AdministradorHotelServicio administradorHotelServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Caracteristica> caracteristicas;

    @Getter @Setter
    private List<Caracteristica> caracteristicasHabitacion;

    @Getter @Setter
    private List<Foto> imagenesHabitacion;

    @Getter @Setter
    private Habitacion habitacion;

    @Getter @Setter
    private List<Habitacion> habitaciones;

    @Getter @Setter
    private List<Cama> camas;

    @PostConstruct
    public void iniciarlizar(){
        hotel=new Hotel();
        imagenes= new ArrayList<>();
        ciudades= administradorHotelServicio.listarCiudades();
        caracteristicas= administradorHotelServicio.listarCaracteristicas();
        imagenesHabitacion=new ArrayList<>();
        habitacion=new Habitacion();
        habitaciones= administradorHotelServicio.listarHabitaciones();
        caracteristicasHabitacion=new ArrayList<>();
        camas=administradorHotelServicio.listarCamas();
    }
    public String registrarHotel(){
        try {
            if (imagenes.size() > 0) {
                if (habitaciones.size() > 0) {


                    Ciudad ciudad = administradorHotelServicio.obtenerCiudad(1);
                    AdministradorHotel administradorHotel = administradorHotelServicio.obtenerAdministradorHotel("1");
                    hotel.setCiudad(ciudad);
                    hotel.setAdministradorHotel(administradorHotel);
                    //hotel.setFotos(imagenes);
                   Hotel h= administradorHotelServicio.crearHotel(hotel);
                   habitaciones.forEach(habitaciones -> {habitaciones.setHotel(h);
                   administradorHotelServicio.crearHabitacion(habitacion);
                   });
                    return "registro_exitoso?faces-redirect=true";
                } else {
                    FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "alerta", "la imagen es obligatoria");
                    FacesContext.getCurrentInstance().addMessage(null, ms);
                }
            }else {
                    FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "alerta", "la imagen es obligatoria");
                    FacesContext.getCurrentInstance().addMessage(null, ms);
                }
            } catch(Exception e){
                FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, ms);
            }
        return null;
    }
    public void subirImagenes(FileUploadEvent event){
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenes.add(nombreImagen);
        }
    }
    public String subirImagen(UploadedFile imagen){
       try {
           File archivo = new File(urlImagenes + "/" + imagen.getFileName());
           OutputStream outputStream = new FileOutputStream(archivo);
           IOUtils.copy(imagen.getInputStream(), outputStream);
           return imagen.getFileName();
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }
    public void crearHabitacion(){
        if(!imagenesHabitacion.isEmpty()){
            habitacion.setFotos(imagenesHabitacion);
            habitaciones.add(habitacion);

            habitacion=new Habitacion();
            habitaciones=new ArrayList<>();
        }else{
            FacesMessage msj=new FacesMessage(FacesMessage.SEVERITY_WARN,"alerta","las imagenes son obligatorias");
            FacesContext.getCurrentInstance().addMessage(null,msj);
        }
    }
}
