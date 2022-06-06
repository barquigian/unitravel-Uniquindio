package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
import co.edu.uniquindio.unitravel.repositorio.ReservaRepo;
import co.edu.uniquindio.unitravel.repositorio.UsuarioRepo;
import co.edu.uniquindio.unitravel.servicios.EmailService;
import co.edu.uniquindio.unitravel.servicios.HotelServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ReservaRepo reservaRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;




    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuarioTest(){
        Usuario u = new Usuario("123412","lucas","lucas@correo.com","1234");
        List<String>telefonos=new ArrayList<>();
        telefonos.add("564334");
        telefonos.add("662343");
        u.setTelefono(telefonos);
        try {
           Usuario guardado= usuarioServicio.registrarUsuario(u);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuarioTest() throws Exception {
        Usuario usuario = usuarioServicio.obtenerUsuario("1234432");
        usuario.setContrasena("123456");
        try {
            Usuario actualizado=usuarioServicio.actualizarUsuario(usuario);
            Assertions.assertEquals("123456",usuario.getContrasena());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuarioTest() throws Exception {
        try {
            usuarioServicio.elimiarUsuario("123456");
            Usuario elimiando=usuarioServicio.obtenerUsuario("123456");
            Assertions.assertNull(elimiando);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarioTest() throws Exception {
        List<Usuario>lista=usuarioServicio.listarUsuario();
        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasTest() throws Exception {
        List<Object[]> reservas=reservaRepo.listaReservaUsuaro("1234432");
        reservas.forEach(r-> System.out.println(r[0]+" "+r[1]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void loginUsuarioTest() throws Exception {
        try {
            Usuario usuario = usuarioServicio.validarLogin("Carlos123@correo.com", "12345");
            Assertions.assertNotNull(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void hacerComentarioTest() throws Exception {

       AdministradorHotel adminHotel=new AdministradorHotel("243342","12345","williHenao@gmail.com","Willian Henao", "prueba","1");
        Ciudad ciudad= new Ciudad(5, "Pereira");
        Hotel hotel=new Hotel(10,"hotel Pereira","cra 05 #23-11","3246464",5,adminHotel,ciudad);
        Usuario u = new Usuario("1234","lucas","lucas@correo.com","1234");


        Usuario usuario=usuarioServicio.obtenerUsuario("1234432");

        LocalDateTime fecha=LocalDateTime.of(2022,03,10,5,32);
        try {
            Comentario c ;
            usuarioServicio.crearComentario(c= new Comentario("1", "muy buen servicio", 5, fecha, hotel, usuario));
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void hacerResevaTest() throws Exception {
        LocalDateTime fechaReserva=LocalDateTime.of(2022,03,25,5,32);
        LocalDateTime fechaInicio=LocalDateTime.of(2022,04,25,5,32);
        LocalDateTime fechaFin=LocalDateTime.of(2022,04,28,5,32);
        AdministradorHotel adminHotel=new AdministradorHotel("243342","12345","williHenao@gmail.com","Willian Henao", "prueba","1");
        Ciudad ciudad= new Ciudad(5, "Pereira");
        Usuario usuario=usuarioServicio.obtenerUsuario("1234432");
        Hotel hotel=new Hotel(10,"hotel Pereira","cra 05 #23-11","3246464",5,adminHotel,ciudad);
        Administrador administrador= new Administrador("prueba","nombre pueba","prueba@gmail.com","12345", "prueva");
        Reserva reserva=new Reserva("prueba",fechaReserva,fechaInicio,fechaFin,"reservado",2,250.500,"1234432",10);
        Habitacion habitacion= new Habitacion(239,155000,2,"102","reservado",hotel);

        List<ReservaHabitacion> habitacionesReserva= new ArrayList<>();
        habitacionesReserva.add(new ReservaHabitacion("1",45.000,reserva,habitacion));

        Ciudad ciudadOrigen= new Ciudad(5,"Pereira");
        Ciudad ciudadDestino= new Ciudad(6,"Cartago");
        List<Silla> sillas= new ArrayList<>();

        Vuelo vuelo= new Vuelo("prueba",5,"disponible",ciudadOrigen,ciudadDestino, administrador,"AviaTour");
        List<Vuelo>vuelos=new ArrayList<>();
        vuelos.add(vuelo);

       // sillas.add("prueba",106.200,vuelos.get(0));


       // List<ReservaSilla> reservaSilla=new ArrayList<>();
        //reservaSilla.add(new ReservaSilla("prueba",200.000,reserva,sillas.get(0)));

        //reserva.setReservaSillas(reservaSilla);
        reserva.setReservaHabitaciones(habitacionesReserva);
        try {
            usuarioServicio.hacerReserva(reserva);
            Assertions.assertNotNull(reserva);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelPorCiuadTest() throws Exception {
        List<Hotel> hotel= usuarioServicio.buscarHotelPorCiudad(1);
                hotel.forEach(System.out::println);
        Assertions.assertNotNull(hotel);

    }
   @Test
   @Sql("classpath:dataset.sql")
   public void enviarCorreoTest() throws Exception {
       boolean estado= emailService.enviarEmail("prueba","nuevo mensaje del proyecto","barquigian@gmail.com");
       System.out.println(estado);

   }
   @Test
    @Sql("classpath:dataset.sql")
   public void modificarReservaTest() throws Exception {

        Reserva reserva= reservaRepo.modificarReserva("1");
       LocalDateTime fechaFin= LocalDateTime.of(2022,03,28,05,30);
        reserva.setFechaFin(fechaFin);
        reservaRepo.save(reserva);
        Assertions.assertEquals(reserva.getFechaFin(),fechaFin);

   }
   /* @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuarioTest() throws Exception {
        List<String>telefono=new ArrayList<>();
        telefono.add("123442");
        Usuario usuario= usuarioServicio.crearUsuario("3124132","Lizeth Baca","liz@correo.com","12345",telefono);
   }*/
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarReservaTest() throws Exception {

        Reserva reserva=reservaRepo.obtenerReservaPorCodigo("1");
        if (reserva!=null) {
            usuarioServicio.eliminarReserva(reserva.getCodigo());
            reservaRepo.delete(reserva);
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarContrasenaTest() throws Exception {

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarPrecioReservaTest() throws Exception {
        double costoTotal=usuarioServicio.consultarPrecioReserva("1");
        System.out.println("costo total: "+costoTotal);


    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarPrecioReservaMasIvaTest() throws Exception {
        double costoSubTotal=usuarioServicio.consultarPrecioReserva("1");
        double costoMasIva=usuarioServicio.consultarPrecioReservaMasIva("1");
        Assertions.assertEquals(304.5, costoMasIva);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudadesTest(){
        List<Ciudad> ciudades= usuarioServicio.listarCiudades();
        System.out.println(ciudades);
        Assertions.assertNotNull(ciudades);
    }
}
