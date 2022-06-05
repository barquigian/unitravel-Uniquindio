package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorio.*;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;
    private HotelRepo hotelRepo;
    private ComentarioRepo comentarioRepo;
    private ReservaRepo reservaRepo;
    private ReservaSillaRepo reservaSillaRepo;
    private ReservaHabitacionRepo reservaHabitacionRepo;
    private EmailService emailService;
    private AdministradorRepo administradorRepo;
    private HabitacionRepo habitacionRepo;
    private CiudadRepo ciudadRepo;



    public UsuarioServicioImp(UsuarioRepo usuarioRepo,HotelRepo hotelRepo,
                              ComentarioRepo comentarioRepo, ReservaRepo reservaRepo,ReservaSillaRepo reservaSillaRepo,
                              ReservaHabitacionRepo reservaHabitacionRepo,EmailService emailService,AdministradorRepo administradorRepo,
                                    HabitacionRepo habitacionRepo, CiudadRepo ciudadRepo) {
        this.usuarioRepo = usuarioRepo;
        this.hotelRepo=hotelRepo;
        this.comentarioRepo = comentarioRepo;
        this.reservaRepo = reservaRepo;
        this.reservaSillaRepo=reservaSillaRepo;
        this.reservaHabitacionRepo=reservaHabitacionRepo;
        this.emailService=emailService;
        this.administradorRepo=administradorRepo;
        this.habitacionRepo= habitacionRepo;
        this.ciudadRepo=ciudadRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {

        Usuario buscado = obtenerUsuario(usuario.getCedula());
        //Usuario usuarioEmail= bus
        if (buscado != null) {
            throw new Exception("La cédula del usuario ya está registrada");
        }
        if(buscado!=null){

        }
        return usuarioRepo.save(usuario);
    }


    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        return usuarioRepo.findById(codigo).orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        Usuario buscado = obtenerUsuario(usuario.getCedula());
        if (buscado == null) {
            throw new Exception("El usuario no existe");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() throws Exception {
        return usuarioRepo.findAll();
    }

    @Override
    public void elimiarUsuario(String cedula) throws Exception {
        Usuario usuario = obtenerUsuario(cedula);

        if (usuario == null) {
            throw new Exception("El usuario no existe");
        }
        usuarioRepo.delete(usuario);
    }

    @Override
    public Usuario validarLogin(String correo, String contrasena) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findByEmailAndContrasena(correo, contrasena);
        if (usuario.isEmpty()) {
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        return usuario.get();
    }

    @Override
    public Comentario crearComentario(Comentario comentario) throws Exception {
        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        if (comentarioGuardado.getCodigo()==null) {
            throw new Exception("El campo de comentario esta vacio");
        }
        return comentarioGuardado;
    }

    @Override
    public Reserva hacerReserva(Reserva reserva) throws Exception {



        /*
        Falta comprobar las fechas
        Vaidar el precio final (iVA)
         */

        List<ReservaHabitacion> habitaciones = reserva.getReservaHabitaciones();

        for (ReservaHabitacion rh : habitaciones) {
            //  if(habitaciones.get().getHabitacion().getEstado()){

        }


        return reservaRepo.save(reserva);
    }

    @Override
    public List<Hotel> buscarHotelPorCiudad(Integer codigoCiudad) throws Exception {
       List<Hotel>hoteles= hotelRepo.obtenerHotelesPorCiudadMenorAMayor(codigoCiudad);
       return hoteles;
    }

    @Override
    public void eliminarReserva(String codigo) throws Exception {
        Reserva reserva= reservaRepo.getById(codigo);
        reservaRepo.delete(reserva);
    }

    @Override
    public Reserva modificarReserva(Reserva reserva) throws Exception {

        if (reserva.getCodigo().isEmpty()) {
            throw new Exception("la reserva no existe");
        }
        reserva.setCantidadPersonas(2);
        reservaRepo.save(reserva);
         return reservaRepo.modificarReserva(reserva.getCodigo());
    }


    @Override
    public List<Reserva> listarReservas(String email) throws Exception {

        List<Reserva>reservas=usuarioRepo.obtenerListaReservasPorEmail(email);
        return reservas;
    }

    @Override
    public void recuperarContraseña(String email) throws Exception {

        Optional<Usuario> usuario=usuarioRepo.findByEmail(email);
        recuperarContraseña(usuario.get().getEmail());
        if (usuario.isEmpty()){
            throw new Exception("el email no pertenece a ningun usuario");
        }

        String contrasena=usuario.get().getContrasena();
        emailService.enviarEmail("Recuperar contraseña","su contraseña es:"+contrasena,"barquigian@gmail.com");
    }

    @Override
    public void cambiarEstadoDeHabitacion(Habitacion habitacion,String estado) throws Exception {
        String estadoHabitacion;


        String disponible="disponible";
        String reservado="reservado";
        cambiarEstadoDeHabitacion(habitacion,estado);
        if(estado.equals("reservado")){
            estadoHabitacion=disponible;
            habitacion.setEstado(estadoHabitacion);
            habitacionRepo.save(habitacion);


        }
        if (estado.equals("disponible")) {
            estadoHabitacion = reservado;
            habitacion.setEstado(estadoHabitacion);
            habitacionRepo.save(habitacion);

        }
    }

    @Override
    public Usuario crearUsuario(String codigo, String nombre, String email, String contrasena, List<String> telefonos) {

        return new Usuario(codigo,nombre,email,contrasena,telefonos);

    }

    @Override
    public void eliminarUsuario(String codigo) {
        Usuario usuario=usuarioRepo.buscarporCedula(codigo);
        eliminarUsuario(usuario.getCedula());
        if (usuario.getCedula().equals(codigo)){
            usuarioRepo.delete(usuario);

        }else {
          throw new RuntimeException();
        }
    }

    @Override
    public double consultarPrecioReserva(String codigoReserva) throws Exception {
        try {

            double costoIva= reservaRepo.calcularPrecioReservaHabitacion(codigoReserva)+reservaRepo.calcularPrecioReservaSilla(codigoReserva);

            return costoIva;
        }catch (Exception e){
            throw new Exception(e);
        }


    }

    @Override
    public double consultarPrecioReservaMasIva(String codigoReserva) throws Exception {
        try {

            double costoIva= reservaRepo.calcularPrecioReservaHabitacion(codigoReserva)*1.05+reservaRepo.calcularPrecioReservaSilla(codigoReserva)*1.05;

            return costoIva;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public boolean verificarDisponibilidadFecha(Reserva reserva) {

        return false;
    }

    @Override
    public List<Hotel> buscarHotelporNombre(String nombreHotel) {
            return hotelRepo.obtenerHotelesPorNombre(nombreHotel);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Hotel> listarHoteles() {
        return null;
    }


}
