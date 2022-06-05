package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarAdministrador(){
        List<Administrador> administrador=administradorRepo.buscarporNombre("car");
        Assertions.assertNotNull(administrador);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarAdministradorPorNombreCompleto(){
        List<Administrador> administrador=administradorRepo.findAllByNombre("Carlos Mauricio");
        Assertions.assertNotNull(administrador);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPorCedulaAdministrador(){
        Administrador administrador=administradorRepo.buscarporCedula("123456");
        Assertions.assertNotNull(administrador);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacionAdministrador(){
        Administrador administrador=administradorRepo.findByEmailAndContrasena("sebas123@gmail.com","12345").get();
        Assertions.assertNotNull(administrador);

    }

}
