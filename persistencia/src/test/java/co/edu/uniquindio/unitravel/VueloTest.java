package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.dto.VueloCiudadDto;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorio.VueloRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vueloRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVuelos(){
        List<Vuelo> vuelos= vueloRepo.obtenerVuelosPorCiudad("Bogota");
        vuelos.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void contarVuelosCiudad(){
        List<VueloCiudadDto> vuelos= vueloRepo.contarVuelosPorCiudad();
        vuelos.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void optenerVuelosEstado(){
        List<Vuelo> vuelos=vueloRepo.obtenerVuelosPorEstado("programado");
        vuelos.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void tableroDeVuelosEstado(){
        List<Object[]> vuelos=vueloRepo.obtenertableroVuelos("programado");
        vuelos.forEach(v -> System.out.println("codigo:"+v[0]+" Ciudad Origen:"+v[1]+" Ciudad Destino:"+v[2]+" Precio:"+v[3]+" aerolinea:"+v[4]+" estado:"+v[5]));
    }

}
