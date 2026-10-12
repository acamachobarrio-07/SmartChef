package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIngredientesRepository extends JpaRepository<Ingredientes, Integer> {

    //Catálogo de ingredientes

    @Query(value = """
    SELECT DISTINCT i.* FROM ingredientes i
    JOIN despensa d ON i.id = d.id_ingredientes
    WHERE d.id_usuario = :idUsuario
    ORDER BY i.nombre ASC
    """, nativeQuery = true)
    List<Ingredientes> obtenerIngredientesPorUsuario(
            @Param("idUsuario") Integer idUsuario
    );


}