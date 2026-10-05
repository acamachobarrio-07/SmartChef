package es.safareyes.smartchef.modelos;

//añadimos etiquetas, se la hacemos a spring boot para declarar algo

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/*La marcamos como tabla*/
@Entity
@Table(name="receta")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Receta {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Short id;

    @Column(name="nombre", length = 150, nullable = false, unique = true)
    private String nombre;

    @Column(name="raciones")
    private Integer raciones;

    @Column(name="tiempo")
    private Integer tiempo;

    @Column(name="calorias")
    private Integer calorias;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="dificultad", length = 300)
    private Integer dificultad;

    // N:M coleccion_receta
    @ManyToMany(mappedBy = "recetas", fetch = FetchType.LAZY)

    private Set<Coleccion> colecciones = new HashSet<>();


}
