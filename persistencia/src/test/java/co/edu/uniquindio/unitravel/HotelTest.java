package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorio.FotoRepo;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarHotel() {

        Ciudad ciudad = ciudadRepo.findById(1).get();
        //Hotel hotel = new Hotel(1,"hotel Tertulia","cra 02 #23-11","324234241",4 , 123,ciudad);
        //Hotel hotelReistrado= hotelRepo.save(hotel);
        //Assertions.assertNotNull(hotelReistrado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHotel() {
       /* Hotel hotel = new Hotel(1,"hotel Tertulia","cra 02 #23-11","324234241",4, 123,1);
        Hotel hotelReistrado= hotelRepo.save(hotel);
        hotelRepo.delete(hotelReistrado);
        Assertions.assertNull(hotelReistrado);

         Optional<Hotel> hotelf= hotelRepo.findById(1);
        Assertions.assertEquals(1,hotelf.get().getCodigo());*/
    }

    @Test
    @Sql
    public void actualizarHotel() {
       /* Hotel hotel = new Hotel(1,"hotel Tertulia","cra 02 #23-11","324234241",4, 123,1);
        Hotel hotelReistrado= hotelRepo.save(hotel);
        hotelReistrado.setDireccion("Cra 02 #23-17");
        hotelRepo.save(hotelReistrado);
        Assertions.assertEquals("cra 02 #23-17", hotelReistrado.getDireccion());*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotel() {
        List<Hotel> hoteles = hotelRepo.findAll();
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar() {
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        System.out.println(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesPorEstrellas() {
        List<Hotel> hotel = hotelRepo.findAllByNumEstrellas(5);
        hotel.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorEstrellasSort() {

        List<Hotel> hoteles = hotelRepo.findAll(Sort.by(Sort.Direction.DESC, "NumEstrellas"));
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorEstrellasCategoriaSort() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorCategorias(3);
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarCiudadPorCodigoHotel() {
        String nombre = hotelRepo.obtenerNombreCiudadPorHotel(1);
        System.out.println(nombre);
        Assertions.assertEquals("Armenia", nombre);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void hotelesPorCiudad() {
        List<Object[]> hoteles = hotelRepo.contarHotelesPorCiudad();
        hoteles.forEach(c -> System.out.println(c[0] + " " + c[1]));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesSinComentarios() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesSinComentarios();
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesPorNombre() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorNombre("a");
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void calificacionPorHotel() {
        List<Object[]> hoteles = hotelRepo.obtenerCalificacionPorHotel();
        hoteles.forEach(c -> System.out.println(c[0] + " " + c[1]));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorCiudad() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorCiudad("1");
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorRangoPrecio() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelPorPrecioRango(200000, 450000, 2);
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql
    private void listarCiudadesMayorAMenor() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorCiudadMenorAMayor(1);
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql
    private void obtenerHotelPorNombre() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesNombre("len");
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql
    private void obtenerFotosPorHotel() {
        List<Foto> fotos=hotelRepo.fotosPorHotel("1");
        fotos.forEach(System.out::println);
    }
    @Test
    @Sql
    private void obtenerHotelesPopulares() {
        List<Hotel>hoteles=hotelRepo.hotelesPopulares();

        hoteles.forEach(System.out::println);
    }
}