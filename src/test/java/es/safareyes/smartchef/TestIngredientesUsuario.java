package es.safareyes.smartchef;

import es.safareyes.smartchef.dtos.DatosIngrediente;
import es.safareyes.smartchef.modelos.Ingredientes;
import es.safareyes.smartchef.repositorios.IIngredientesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestIngredientesUsuario {

    @Autowired
    private IIngredientesRepository repository;

    @Test
    void obtenerIngredientesPorUsuario() {
        List<DatosIngrediente> ingredientes = repository.obtenerIngredientesPorUsuario(2);
    }

}
