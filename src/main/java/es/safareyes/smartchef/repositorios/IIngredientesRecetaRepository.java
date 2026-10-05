package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.IngredientesReceta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientesRecetaRepository extends JpaRepository<IngredientesReceta, Integer> {
}
