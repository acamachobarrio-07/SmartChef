package es.safareyes.smartchef;

import es.safareyes.smartchef.dtos.DatosReceta;
import es.safareyes.smartchef.modelos.Receta;
import es.safareyes.smartchef.repositorios.IRecetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestDetalleReceta {

    @Autowired
    private IRecetaRepository repository;

    @Test
    void obtenerDetalleUnicoReceta() {
        List<DatosReceta> receta = repository.obtenerdetalleRecetaconIngredientes(2);
    }
}
