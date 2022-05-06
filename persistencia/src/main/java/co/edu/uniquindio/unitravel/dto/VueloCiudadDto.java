package co.edu.uniquindio.unitravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class VueloCiudadDto {
    private String nombreCiudad;
    private Long numeroVuelos;

}
