package es.safareyes.smartchef;

import es.safareyes.smartchef.modelos.Receta;
import es.safareyes.smartchef.repositorios.IRecetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.data.repository.query.Param;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestConsultaCatalogo {

    @Autowired
    private IRecetaRepository repository;

    @Test
    void
    buscarporFiltros(){
        List<Receta> tiempoMax=repository.buscarConFiltros(20,1);
    }






}
