package es.safareyes.smartchef;

import es.safareyes.smartchef.dtos.DatosColeccionReceta;
import es.safareyes.smartchef.repositorios.IColeccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestColeccionReceta {

    @Autowired
    private IColeccionRepository repository;

    @Test
    void consultarColeccionesConRecetas() {
        List<DatosColeccionReceta> colecciones = repository.obtenerColeccionesConRecetasPorUsuario(2);
    }
}
