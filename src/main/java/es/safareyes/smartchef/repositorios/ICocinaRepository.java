package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.dtos.DatosSemanaCalorias;
import es.safareyes.smartchef.modelos.Cocina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ICocinaRepository extends JpaRepository<Cocina, Integer> {
    //semana por dias con calorias totales
    @Query("""
    SELECT new es.safareyes.smartchef.dtos.DatosSemanaCalorias(
        CAST(c.fecha AS LocalDate),
        CAST(FUNCTION('TO_CHAR', c.fecha, 'TMDay') AS String),
        COUNT(r.id),
        CAST(COALESCE(SUM(r.calorias), 0) AS Long)
    )
    FROM Cocina c
    JOIN c.receta r
    WHERE c.usuario.id = :idUsuario
      AND c.fecha >= :desde
    GROUP BY CAST(c.fecha AS LocalDate), CAST(FUNCTION('TO_CHAR', c.fecha, 'TMDay') AS String)
    ORDER BY CAST(c.fecha AS LocalDate) ASC
    """)
    List<DatosSemanaCalorias> obtenerResumenSemanal(
            @Param("idUsuario") Integer idUsuario,
            @Param("desde") LocalDate desde);

}
