package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.repositorio.CaracteristicaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaracteristicaTest {
    @Autowired
    private CaracteristicaRepo caracteristicaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCarateristicas(){
        Caracteristica caracteristica= caracteristicaRepo.obtenerCaracteristica(1);
        Assertions.assertNotNull(caracteristica);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCarateristicas(){
        List<Caracteristica> caracteristicas= caracteristicaRepo.findAll();
        Assertions.assertNotNull(caracteristicas);
    }
}
