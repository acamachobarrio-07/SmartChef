package es.safareyes.smartchef;

import es.safareyes.smartchef.dtos.DatosRecetasPopulares;
import es.safareyes.smartchef.repositorios.IRecetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRecetasPopulares {

    @Autowired
    private IRecetaRepository repository;

    @Test
    void consultarTopRecetasPopulares() {
        // Limitamos los resultados a los 5 primeros (Top 5)
        List<DatosRecetasPopulares> populares = repository.findTop5ByUsuario(2);
    }
}
