package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.dto.ComentarioUsuarioDto;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrar(){
        Usuario usuario= new Usuario("66434","Esteban Vasquez","Esteban@correo", "12345");
        Usuario usuarioGuardado= usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);

    }
    @Test
    public void eliminar(){
        Usuario usuario= new Usuario("66434","Esteban Vasquez","Esteban@correo", "12345");
        Usuario usuarioGuardado= usuarioRepo.save(usuario);
        usuarioRepo.delete(usuarioGuardado);
        Usuario usuarioEncontrado= usuarioRepo.findById("66434").orElse(null);

        Assertions.assertNull(usuarioEncontrado);
    }
    @Test
    public void actualizar(){
        Usuario usuario= new Usuario("66434","Esteban Vasquez","Esteban@correo", "12345");
        Usuario usuarioGuardado=usuarioRepo.save(usuario);
        usuarioGuardado.setContrasena("123456");
        usuarioRepo.save(usuarioGuardado);
        Usuario usuarioBuscado= usuarioRepo.findById("66434").orElse(null);
        Assertions.assertEquals("123456",usuarioBuscado.getContrasena());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarios(){

        List<Usuario>usuarios=usuarioRepo.findAll();

        System.out.println(usuarios);
        Assertions.assertNotNull(usuarios);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuariosPorNombre(){

        List<Usuario>usuarios=usuarioRepo.findAllByNombre("Carlos Soto");
        usuarios.forEach(System.out::println);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void AutenticacionCorreo(){

        Optional<Usuario> usuarios=usuarioRepo.findByEmailAndContrasena("Fabian123@correo.com","12345");

        System.out.println(usuarios.orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPorPaginador() {
        Page<Usuario> usuarios=usuarioRepo.findAll(PageRequest.of(0,2));
        usuarios.get().forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuariosPorNombreSort() {

        List<Usuario> usuarios = usuarioRepo.findAll(Sort.by("nombre"));
        usuarios.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarContrasenaporCedula() {

       Usuario usuario= usuarioRepo.buscarporCedula("1234432");
       usuario.setContrasena("123456");
       usuarioRepo.save(usuario);
       Assertions.assertEquals("123456",usuario.getContrasena());
        System.out.println(usuario);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEmailporCedula() {

        Usuario usuario= usuarioRepo.buscarporCedula("1234432");
        System.out.println(usuario);
        usuario.setEmail("Fabi123@correo.com");
        usuarioRepo.save(usuario);
        Assertions.assertEquals("Fabi123@correo.com",usuario.getEmail());
        System.out.println(usuario);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarResevasPorEmail(){
        List<Reserva> reservas= usuarioRepo.obtenerListaReservasPorEmail("Manuel123@correo.com");
        reservas.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosPorUsuario(){
        //List<Object[]> comenterios= usuarioRepo.obtenerComentarios();
        //comenterios.forEach(c -> System.out.println(c[0]+" "+c[1]));
    }
   /* @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosPorUsuarioDto(){
        List<ComentarioUsuarioDto> comenterios= usuarioRepo.obtenerComentariosDto();
        comenterios.forEach(System.out::println);
    }*/
    @Test
    @Sql("classpath:dataset.sql")
    public void listarResevas(){
        List<Object[]> reservas= usuarioRepo.obtenerReservas();
        reservas.forEach(c -> System.out.println(c[0]+" "+c[1]));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarioPorTelefono(){
        List<Usuario> usuarios= usuarioRepo.obtenerUsuarioporTelefono("33456513");
        usuarios.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarioPorTelefonoDisnic(){
        List<String> usuarios= usuarioRepo.obtenerUsuarioPorTelefonoDisnic();
        usuarios.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuario(){

        Usuario usuario= new Usuario("6536", "Cristian Ortiz", "crisO@correo.com","12345");
        try{

            if(usuario!=null);
            usuarioRepo.save(usuario);
        }catch (Exception e){
            Assertions.assertNull(usuario);
        }
    }
}
