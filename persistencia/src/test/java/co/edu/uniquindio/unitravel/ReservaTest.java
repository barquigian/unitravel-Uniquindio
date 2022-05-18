package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.dto.ReservaDto;
import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.AdministradorRepo;
import co.edu.uniquindio.unitravel.repositorio.ReservaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {
    @Autowired
    private ReservaRepo reservaRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservas() {
        LocalDateTime fecha= LocalDateTime.of(2022,05,15,05,30);
        List<Object[]> reservas = reservaRepo.obtenerReservasPorHabitacines(1,fecha);
        reservas.forEach(r -> System.out.println(r[0]+"- "+r[1]+"- "+r[2]));
        Assertions.assertNotNull(reservas);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasDto() {
        LocalDateTime fecha= LocalDateTime.of(2022,05,14,05,30);
        List<ReservaDto> reservas = reservaRepo.obtenerReservasPorHabitacinesDto(1,fecha);
        reservas.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void numeroReservasPorHotel() {
        int numeroReservas=reservaRepo.ObtenerNumeroReservas(1);
        System.out.println(numeroReservas);
        Assertions.assertNotNull(numeroReservas);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarPrecioReservaPorCodigoUsuario() {
        List<Object[]> reservas = reservaRepo.obtenerValorReserva("1234432");
        reservas.forEach(r -> System.out.println(r[0] + "- " + r[1]+"- "+r[2]+"- "+r[2]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarReservaPorCodigoUsuario() {
        List<Object[]> reservas = reservaRepo.listaReservaUsuaro("123456");
        reservas.forEach(r -> System.out.println(r[0] + "- " + r[1]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void modificarReservaPorCodigoReserva(){
        Reserva reserva= reservaRepo.modificarReserva("1");
        LocalDateTime fechafin=LocalDateTime.of(2022,03,28,5,32);
        reserva.setFechaFin(fechafin);
        reservaRepo.save(reserva);
        System.out.println(reserva);
        Assertions.assertNotNull(reserva);
    }
    @Test
    public void crearReserva(){
        LocalDateTime fechaFin=LocalDateTime.of(2022,03,28,5,32);
        LocalDateTime fechaInicio=LocalDateTime.of(2022,03,25,5,32);
        LocalDateTime fechaReserva=LocalDateTime.of(2022,03,10,5,32);
        Ciudad ciudad= new Ciudad(10,"Calarca");
        List<String>telefonos= new ArrayList<>();
        telefonos.add("324132");
        Administrador administrador= new Administrador("32141","Sergio Betacour","sergio@correo.com","12345","4");
        Usuario usuario= new Usuario("163436", "Manuel Ortiz", "manu@correo.com","12345");
        AdministradorHotel administradorHotel=new AdministradorHotel("prueba","12345","prueba@correo.com", "Ricardo prueba","1",administrador.getCedula());
        Hotel hotel= new Hotel(9,"hotel imperial","cra 32#34-23","6665488",4,administradorHotel,ciudad);

        Reserva reserva=new Reserva("prueba",fechaReserva,fechaInicio,fechaFin,"reservado",2,450.000,usuario.getCedula(),hotel.getCodigo());
        if(reserva.getCodigo()!=null){
            reservaRepo.save(reserva);
            Assertions.assertNotNull(reserva);
            System.out.println(reserva);
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void EliminarReserva() {
        Reserva reserva = reservaRepo.obtenerReservaPorCedula("1234432");
        if (reserva.getCodigo() == "123456") {
            reservaRepo.delete(reserva);
            Assertions.assertNull(reserva);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPrecioReservas() {
        List<Object[]> reservas= reservaRepo.obtenerTotalPorReserva("12345");
        reservas.forEach(r-> System.out.println("reserva: "+r[0]+" precio habitacion:"+r[1]+ "precio reserva silla "+r[2]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasUsuario() {
        List<Object[]> reservas= reservaRepo.obtenerReservayHabitacionPorCedula("12345");
        reservas.forEach(r -> System.out.println("reserva:"+r[0]+" habitacion:"+r[1]+" sillas:"+r[2]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNumeroReservasUsuario() {
        Integer reservas= reservaRepo.obtenerNumeroResevas(1);
        System.out.println(reservas);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void vuelosMasApetecidos(){
        List<Object[]> vuelos= reservaRepo.vuelosMasApetecidos();
        vuelos.forEach(v -> System.out.println("Codigo Vuelo:"+v[0]+" Cantidad Personas :"+v[1]));
        Assertions.assertNotNull(vuelos);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoReserva(){
        String estadoReserva=reservaRepo.obtenerEstadoReserva("1");
        if(estadoReserva.equals("reservado")){
            estadoReserva="disponible";
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarReservaTest(){
        Reserva reserva=reservaRepo.obtenerReservaPorCodigo("1");
        if(reserva!=null)
        reservaRepo.delete(reserva);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void calcularPrecioReservaSillaTest(){
        double precioReservaSilla= reservaRepo.calcularPrecioReservaSilla("1");
        Reserva reserva=reservaRepo.obtenerReservaPorCodigo("1");
        System.out.println(reserva);


        System.out.println("costo sillas: "+precioReservaSilla);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void calcularPrecioReservaHabitacionTest(){

        try {
            Reserva reserva=reservaRepo.obtenerReservaPorCodigo("1");
            double precioReservaHabitacion= reservaRepo.calcularPrecioReservaHabitacion("1");
            System.out.println("costo habitaciones: "+precioReservaHabitacion);

        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
