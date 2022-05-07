package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.dto.ReservaDto;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorio.ReservaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {
    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservas() {
        LocalDate fecha= LocalDate.of(2022,06,30);
        List<Object[]> reservas = reservaRepo.obtenerReservasPorHabitacines("1",fecha);
        reservas.forEach(r -> System.out.println(r[0]+"- "+r[1]+"- "+r[2]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasDto() {
        LocalDate fecha= LocalDate.of(2022,06,30);
        List<ReservaDto> reservas = reservaRepo.obtenerReservasPorHabitacinesDto("1",fecha);
        reservas.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void numeroReservasPorHotel() {
        int numeroReservas=reservaRepo.ObtenerNumeroReservas("1");
        System.out.println(numeroReservas);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarPrecioReservaPorCodigoUsuario() {
        List<Object[]> reservas = reservaRepo.obtenerValorReserva("123456");
        reservas.forEach(r -> System.out.println(r[0] + "- " + r[1]+"- "+r[2]+"- "+r[2]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarReservaPorCodigoUsuario() {
        List<Object[]> reservas = reservaRepo.listaReservaUsuaro("123456");
        reservas.forEach(r -> System.out.println(r[0] + "- " + r[1]));
    }
    @Test
    @Sql
    public void modificarReservaPorCodigoReserva(){
        Reserva reserva= reservaRepo.modificarReserva("1");
        LocalDateTime fechafin=LocalDateTime.of(2022,03,28,5,32);
        reserva.setFecha_fin(fechafin);
        reservaRepo.save(reserva);
        System.out.println(reserva);
    }
    @Test
    @Sql
    public void crearReserva(String codigo, LocalDateTime fecha, LocalDateTime fechaInicio, LocalDateTime fechaFin,
                                String estado, int cantidadPersonas, Usuario usuario, Hotel hotel){
        Reserva reserva=new Reserva(codigo,fecha,fechaInicio,fechaFin,estado,cantidadPersonas,usuario,hotel);
        if(reserva.getCodigo().equals(codigo)){
            reservaRepo.save(reserva);
        }
        System.out.println(reserva);
    }
    @Test
    @Sql
    public void EliminarReserva(){
        Reserva reserva= reservaRepo.obtenerReservaPorCedula("123456");
        if(reserva.getCodigo()=="123456") {
            reservaRepo.delete(reserva);
            System.out.println("la reserva:"+"123456"+" a sido elimanada con exito");
            Assertions.assertEquals("123456",reserva.getCodigo());
        }else{
            System.out.println("no existe una reserva con este codigo");
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
    }
}
