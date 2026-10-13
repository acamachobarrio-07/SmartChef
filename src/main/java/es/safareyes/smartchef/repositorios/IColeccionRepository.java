package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.dtos.DatosColeccionReceta;
import es.safareyes.smartchef.modelos.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColeccionRepository extends JpaRepository<Coleccion, Integer> {

    //Mis colecciones con sus recetas
    @Query("""
    SELECT new es.safareyes.smartchef.dtos.DatosColeccionReceta(
        c.nombre,
        r.nombre,
        r.tiempo,
        r.eRecetaDificultad
    )
    FROM Coleccion c
    JOIN c.recetas r
    WHERE c.usuario.id = :idUsuario
    ORDER BY c.nombre ASC, r.nombre ASC
    """)
    List<DatosColeccionReceta> obtenerColeccionesConRecetasPorUsuario(@Param("idUsuario") Integer idUsuario);
}

