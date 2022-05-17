package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.dto.VueloCiudadDto;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo,String>{

    //obtiene los vuelos de una determinada ciudad de origen
    @Query("select v from Vuelo v where v.ciudadOrigen.nombre= :ciudad")
    List<Vuelo> obtenerVuelosPorCiudad(String ciudad);
    //cuenta los vuelos de cada ciudad de origen
    @Query("select new co.edu.uniquindio.unitravel.dto.VueloCiudadDto(v.ciudadOrigen.nombre,count (v)) from Vuelo v group by v.ciudadOrigen")
    List<VueloCiudadDto> contarVuelosPorCiudad();

    @Query("select v from Vuelo v where v.estado=:estado")
    List<Vuelo> obtenerVuelosPorEstado(String estado);

    @Query("select v.codigo,v.ciudadOrigen, v.ciudadDestino, v.aerolinea from Vuelo v where v.estado = :estado" )
    List<Object[]> obtenertableroVuelos(String estado);




}
