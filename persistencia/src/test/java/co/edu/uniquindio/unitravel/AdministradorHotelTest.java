package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.AdministradorHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorHotelTest {
    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginAdministradorTest() throws Exception {
        try {
            AdministradorHotel administradorHotel = administradorHotelRepo.findByEmailAndContrasena("sebas123@gmail.com","12345");
            Assertions.assertNotNull(administradorHotel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarNombreAdministradorTest() throws Exception {
        AdministradorHotel administradorHotel= administradorHotelRepo.obtenerAdministradorHotel("1");

            try{
                if (administradorHotel.getCodigo().equals("1"));
                 Assertions.assertNotNull(administradorHotel.getCodigo());
                 }catch (Exception e){
                     e.printStackTrace();
        }

    }
}
