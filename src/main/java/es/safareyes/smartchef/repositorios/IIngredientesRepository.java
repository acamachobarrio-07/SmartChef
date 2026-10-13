package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.dtos.DatosIngrediente;
import es.safareyes.smartchef.modelos.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIngredientesRepository extends JpaRepository<Ingredientes, Integer> {

    //Catálogo de ingredientes por usuario

    @Query("""
    SELECT DISTINCT new es.safareyes.smartchef.dtos.DatosIngrediente(
        i.nombre,
        i.eIngredientesTipoCantidad,
        i.calorias,
        i.precio
    )
    FROM Despensa d 
    JOIN d.ingrediente i 
    WHERE d.usuario.id = :idUsuario 
    ORDER BY i.nombre ASC
    """)
    List<DatosIngrediente> obtenerIngredientesPorUsuario(@Param("idUsuario") Integer idUsuario);

}