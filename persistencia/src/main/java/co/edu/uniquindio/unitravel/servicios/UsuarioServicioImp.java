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


    public UsuarioServicioImp(UsuarioRepo usuarioRepo,HotelRepo hotelRepo,
                              ComentarioRepo comentarioRepo, ReservaRepo reservaRepo,ReservaSillaRepo reservaSillaRepo,
                              ReservaHabitacionRepo reservaHabitacionRepo,EmailService emailService,AdministradorRepo administradorRepo,
                                    HabitacionRepo habitacionRepo) {
        this.usuarioRepo = usuarioRepo;
        this.hotelRepo=hotelRepo;
        this.comentarioRepo = comentarioRepo;
        this.reservaRepo = reservaRepo;
        this.reservaSillaRepo=reservaSillaRepo;
        this.reservaHabitacionRepo=reservaHabitacionRepo;
        this.emailService=emailService;
        this.administradorRepo=administradorRepo;
        this.habitacionRepo= habitacionRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {

        Usuario buscado = obtenerUsuario(usuario.getCedula());
        if (buscado != null) {
            throw new Exception("El codigo de usuario ya esta registrado");
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
    public List<Hotel> buscarHotelPorCiudad(String nombreCiudad) throws Exception {
        return hotelRepo.obtenerHotelesPorCiudad(nombreCiudad);
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
        return usuarioRepo.obtenerListaReservasPorEmail(email);
    }

    @Override
    public void recuperarContraseña(String email) throws Exception {
        Optional<Usuario> usuario=usuarioRepo.findByEmail(email);
        if (usuario.isEmpty()){
            throw new Exception("el email no pertenece a ningun usuario");
        }

        String contrasena=usuario.get().getContrasena();
        emailService.enviarEmail("Recuperar contraseña","su contraseña es:"+contrasena,"barquigian@gmail.com");
    }

    @Override
    public Habitacion cambiarEstadoDeHabitacion(Habitacion habitacion,String estado) throws Exception {
        String estadoHabitacion=habitacion.getEstado();

        String disponible="disponible";
        String reservado="reservado";

        if(estadoHabitacion.equals("reservado")){
            estadoHabitacion=disponible;
            habitacion.setEstado(estadoHabitacion);
            habitacionRepo.save(habitacion);
        }
        if (estadoHabitacion.equals("disponible")) {
            estadoHabitacion = reservado;
            habitacion.setEstado(estadoHabitacion);
            habitacionRepo.save(habitacion);

        }
            return habitacion;
    }

    @Override
    public Usuario crearUsuario(String codigo, String nombre, String email, String contrasena, List<String> telefonos) {

        return new Usuario(codigo,nombre,email,contrasena,telefonos);

    }

    @Override
    public void eliminarUsuario(String codigo) {
        Usuario usuario=usuarioRepo.buscarporCedula(codigo);
        if (usuario.getCedula().equals(codigo)){
            usuarioRepo.delete(usuario);

        }else {
          throw new RuntimeException();
        }
    }


}
