package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.dtos.DatosIngrediente;
import es.safareyes.smartchef.modelos.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIngredientesRepository extends JpaRepository<Ingredientes, Integer> {

    //Catálogo de ingredientes disponibles (público)

    List<Ingredientes> findAllByOrderByNombreAsc();

}