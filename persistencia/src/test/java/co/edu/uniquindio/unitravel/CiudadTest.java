package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorio.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelPorCiudad(){
        List<Hotel> hoteles= ciudadRepo.buscarHotelPorCiudad("Armenia");
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarVueloPorCiudad(){
        List<Vuelo> vuelos= ciudadRepo.buscarVuelosPorCiudad(1);
        vuelos.forEach(System.out::println);
        Assertions.assertNotNull(vuelos);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades(){
        List<Ciudad> ciudades= ciudadRepo.listarCiudades();
        Assertions.assertNotNull(ciudades);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarCiudad(){
        Ciudad ciudad= ciudadRepo.obtenerCiudad("Armenia");
        Assertions.assertEquals("Armenia",ciudad.getNombre());
    }
}
