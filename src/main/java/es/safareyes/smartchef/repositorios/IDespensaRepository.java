package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.dtos.DatosDespensa;
import es.safareyes.smartchef.modelos.Despensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDespensaRepository extends JpaRepository<Despensa, Integer> {

    //Mi despensa con los próximos a caducar

    @Query("""
    SELECT new es.safareyes.smartchef.dtos.DatosDespensa(
        i.nombre,
        d.cantidad,
        d.caducidad
    )
    FROM Despensa d
    JOIN d.ingrediente i
    WHERE d.usuario.id = :idUsuario
    ORDER BY d.caducidad ASC
    """)
    List<DatosDespensa> obtenerDespensaProximoCaducar(@Param("idUsuario") Integer idUsuario);
}

