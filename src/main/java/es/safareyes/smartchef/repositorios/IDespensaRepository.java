package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Despensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDespensaRepository extends JpaRepository<Despensa, Integer> {

    //Mi despensa con los próximos a caducar

    @Query(value = """
    SELECT d.* FROM despensa d
    JOIN ingredientes i ON d.id_ingredientes = i.id
    WHERE d.id_usuario = :idUsuario
    ORDER BY d.caducidad ASC NULLS LAST
    """, nativeQuery = true)
    List<Despensa> obtenerDespensaProximoCaducar(
            @Param("idUsuario") Integer idUsuario
    );

}
