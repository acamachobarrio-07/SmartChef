package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientesRepository extends JpaRepository<Ingredientes, Integer> {

}