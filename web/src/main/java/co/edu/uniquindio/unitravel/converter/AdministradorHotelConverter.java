package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class AdministradorHotelConverter implements Converter<AdministradorHotel>, Serializable {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    /**
     * @param context   {@link FacesContext} for the request being processed
     * @param component {@link UIComponent} with which this model object
     *                  value is associated
     * @param value     String value to be converted (may be <code>null</code>)
     * @return
     */
    @Override
    public AdministradorHotel getAsObject(FacesContext context, UIComponent component, String value) {
        try{
            AdministradorHotel administradorHotel = administradorHotelServicio.obtenerAdministradorHotel(value);
            return administradorHotel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param context   {@link FacesContext} for the request being processed
     * @param component {@link UIComponent} with which this model object
     *                  value is associated
     * @param value     Model object value to be converted
     *                  (may be <code>null</code>)
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, AdministradorHotel value) {
        if(value!=null){
            return value.getCedula().toString();
        }

        return "";
    }
}
