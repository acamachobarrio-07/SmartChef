package es.safareyes.smartchef;

import es.safareyes.smartchef.dtos.DatosDespensa;
import es.safareyes.smartchef.modelos.Despensa;
import es.safareyes.smartchef.repositorios.IDespensaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestDespensaProximoCaducar {

    @Autowired
    private IDespensaRepository repository;

    @Test
    void obtenerDespensaPorUsuarioProximosCaducar() {
        List<DatosDespensa> despensa = repository.obtenerDespensaProximoCaducar(2);    }
}
