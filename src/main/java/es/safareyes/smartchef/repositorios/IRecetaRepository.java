package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.dtos.DatosFiltradoReceta;
import es.safareyes.smartchef.dtos.DatosReceta;
import es.safareyes.smartchef.dtos.DatosRecetasPopulares;
import es.safareyes.smartchef.dtos.InformeRecetas;
import es.safareyes.smartchef.modelos.ERecetaDificultad;
import es.safareyes.smartchef.modelos.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Integer> {

    //Catálogo con filtros

    @Query("""
    SELECT new es.safareyes.smartchef.dtos.DatosFiltradoReceta(
        r.nombre,
        r.raciones,
        r.tiempo,
        r.calorias,
        r.eRecetaDificultad
    )
    FROM Receta r
    WHERE (:tiempoMax IS NULL OR r.tiempo <= :tiempoMax)
      AND (:dificultadMin IS NULL OR CAST(r.eRecetaDificultad AS integer) >= :dificultadMin)
    ORDER BY r.nombre ASC
    """)
    List<DatosFiltradoReceta> buscarConFiltros(
            @Param("tiempoMax") Integer tiempoMax,
            @Param("dificultadMin") Integer dificultadMin
    );

    //Detalle receta con ingredientes
    @Query("""
    SELECT new es.safareyes.smartchef.dtos.DatosReceta(
        r.nombre,
        r.raciones,
        r.tiempo,
        r.calorias,
        r.descripcion,
        r.eRecetaDificultad
    )
    FROM Receta r
    WHERE r.id = :idReceta
    """)
    List<DatosReceta> obtenerdetalleRecetaconIngredientes(@Param("idReceta") Integer idReceta);

    //top 5 recetas mas cocinadas y mas guardadas

    @Query("""
    SELECT new es.safareyes.smartchef.dtos.DatosRecetasPopulares(
        r.nombre,
        r.eRecetaDificultad,
        r.tiempo,
        COUNT(DISTINCT c.id),
        COUNT(DISTINCT col.id)
    )
    FROM Receta r
    LEFT JOIN Cocina c ON c.receta.id = r.id AND c.usuario.id = :idUsuario
    LEFT JOIN r.colecciones col
    WHERE c.id IS NOT NULL OR col.id IS NOT NULL
    GROUP BY r.id, r.nombre, r.eRecetaDificultad, r.tiempo
    ORDER BY (COUNT(DISTINCT c.id) + COUNT(DISTINCT col.id)) DESC
    """)
    List<DatosRecetasPopulares> findTop5ByUsuario(@Param("idUsuario") Integer idUsuario);
}

    //@Query("""
    //SELECT p FROM Prestamo p
    //WHERE p.estado = :estado AND p.fechaPrestamo < :limite
    //ORDER BY p.fechaPrestamo ASC
    //""")
    //List<Prestamo> buscarRetrasados(@Param("estado") EstadoPrestamo estado,
    //@Param("limite") LocalDate limite);

    /*
    * 1º METODO DE CONSULTA
    * extender JPA podemos hacer consultas por extender el nombre completo
    * las consultas nos va a devolver una lista
    * select from continentes where nombre like %américa% and orden<4
    * ejemplo consulta: List<Continente>findAllByNombreContiningAndORdenLessThan(String nombre, Int orden);
    * en el test probamos el metodo al test le tenemos que pasar las variables de entorno
     * */

    /*
    * 2º METODO DE CONSULTA MEZCLA SQL Y JAVA (JPQL)
    * @Query("select e from Especie where e.tipoAgua.nombre=:nombreAgua")
    * List<Especie> buscarEspeciePorNombreTipoAgua(@Param ("nombreAgua")String nombre)
    * una vez que lo tengo construido probamos en el test!
    * */

    /*
    * 3º METODO SQL NATIVO
    * @Query (value = select e.* from especie e join cat_tipo_agua cta on cta.id = e.id_tipo_agua where cta.nombre=:agua, nativeQuery=true)
    * List<Continente> buscarPorAgua(@Param("agua" String nombreAgua)
    * */

