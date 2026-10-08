package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Integer> {

    @Query(value = """
    SELECT r.* FROM receta r
    WHERE (:tiempoMax IS NULL OR r.tiempo <= :tiempoMax)
      AND (:dificultadMin IS NULL OR r.dificultad >= :dificultadMin)
    ORDER BY r.nombre ASC
    """, nativeQuery = true)
    List<Receta> buscarConFiltros(
            @Param("tiempoMax") Integer tiempoMax,
            @Param("dificultadMin") Integer dificultadMin
    );

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
}
