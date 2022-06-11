package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;

    @Autowired
    private HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarHotel() {

        Ciudad ciudad = ciudadRepo.findById(1).get();
        AdministradorHotel administradorHotel = administradorHotelRepo.obtenerAdministradorHotel("1");
        Hotel hotel = new Hotel(9, "hotel Casa Grande", "cra 02 #23-16", "32345341", 4, administradorHotel, ciudad);
        Hotel hotelReistrado = hotelRepo.save(hotel);
        Assertions.assertNotNull(hotelReistrado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHotel() {
        Ciudad ciudad = ciudadRepo.findById(1).get();
        AdministradorHotel administradorHotel = administradorHotelRepo.obtenerAdministradorHotel("1");
        Hotel hotel = new Hotel(9, "hotel Casa Grande", "cra 02 #23-16", "32345341", 4, administradorHotel, ciudad);
        hotelRepo.delete(hotel);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHotel() {
        Ciudad ciudad = ciudadRepo.findById(1).get();
        AdministradorHotel administradorHotel = administradorHotelRepo.obtenerAdministradorHotel("1");
        Hotel hotel = new Hotel(9, "hotel Casa Grande", "cra 02 #23-16", "32345341", 4, administradorHotel, ciudad);
        hotel.setDireccion("cra 04 #22-16");
        hotelRepo.save(hotel);
        Assertions.assertEquals("cra 04 #22-16", hotel.getDireccion());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotel() {
        List<Hotel> hoteles = hotelRepo.findAll();
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar() {
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        System.out.println(hotel);
        Assertions.assertNotNull(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesPorEstrellas() {
        List<Hotel> hotel = hotelRepo.findAllByNumEstrellas(3);
        hotel.forEach(System.out::println);
        Assertions.assertNotNull(hotel);

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
        Assertions.assertNotNull(hoteles);
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
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesSinComentarios() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesSinComentarios();
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesPorNombre() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorNombre("a");
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void calificacionPorHotel() {
        List<Object[]> hoteles = hotelRepo.obtenerCalificacionPorHotel();
        hoteles.forEach(c -> System.out.println(c[0] + " " + c[1]));
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorCiudad() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorCiudad("1");
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorRangoPrecio() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelPorPrecioRango(200000, 450000, 2);
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql
    private void listarCiudadesMayorAMenor() {
        List<Hotel> hoteles = hotelRepo.obtenerHotelesPorCiudadMenorAMayor(1);
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles);
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
        List<Foto> fotos = hotelRepo.fotosPorHotel("1");
        fotos.forEach(System.out::println);
        Assertions.assertNotNull(fotos);
    }

    @Test
    @Sql
    private void obtenerHotelesPopulares() {
        List<Hotel> hoteles = hotelRepo.hotelesPopulares();

        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesPorId() {
        Hotel hotel = hotelRepo.findById(1).get();
        System.out.println(hotel);
        Assertions.assertNotNull(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHoteles() {
        List<Hotel> hoteles= hotelRepo.listarHoteles();
        System.out.println(hoteles);
        Assertions.assertNotNull(hoteles);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHabitacionesEnRangoFechas() {
        LocalDateTime primera =  LocalDateTime.of(2022, 1,1,0,0);
        LocalDateTime segunda =  LocalDateTime.of(2022, 3,3,0,0);
        List<Habitacion> habitaciones= habitacionRepo.habitacionesConReserva(primera, segunda);
        if(!habitaciones.isEmpty()){
            for(Habitacion habitacion: habitaciones){
                System.out.println(habitacion.getCodigo() + "," + habitacion.getHotel().getCodigo());
            }
        }
        Assertions.assertTrue(habitaciones.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerFotosHabitacion() {
        List<String> fotos = habitacionRepo.urlFotosHabitacion(1);
        if(!fotos.isEmpty()){
            for(String foto: fotos){
                System.out.println(foto);
            }
        }
        Assertions.assertTrue(fotos.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerFotosHotel() {
        List<String> fotos = hotelRepo.urlFotosHotel(1);
        if(!fotos.isEmpty()){
            for(String foto: fotos){
                System.out.println(foto);
            }
        }
        Assertions.assertTrue(!fotos.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void hotelesSinReservaFechasYEnCiudad() {
        LocalDateTime primera =  LocalDateTime.of(2022, 6,1,0,0);
        LocalDateTime segunda =  LocalDateTime.of(2022, 8,3,0,0);
        String ciudad = "Armenia";
        List<Hotel> hoteles= hotelRepo.hotelesSinReservaFechasYEnCiudad(primera,segunda,ciudad);
        if(!hoteles.isEmpty()){
            for(Hotel hotel: hoteles){
                System.out.println(hotel.getCodigo() + "," + hotel.getNombre());
            }
        }
        Assertions.assertTrue(hoteles.isEmpty());
    }

}