package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="receta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"pasos", "ingredientesReceta", "fotos", "colecciones"})
@ToString(exclude = {"pasos", "ingredientesReceta", "fotos", "colecciones"})
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

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

    @Enumerated(EnumType.ORDINAL)
    @Column(name="dificultad")
    private ERecetaDificultad eRecetaDificultad;

    @ManyToMany(mappedBy = "recetas", fetch = FetchType.LAZY)
    private Set<Coleccion> colecciones = new HashSet<>();

    @OneToMany(mappedBy = "receta", fetch = FetchType.LAZY)
    private List<Paso> pasos = new ArrayList<>();

    @OneToMany(mappedBy = "receta", fetch = FetchType.LAZY)
    private List<IngredientesReceta> ingredientesReceta = new ArrayList<>();

    @OneToMany(mappedBy = "receta", fetch = FetchType.LAZY)
    private List<Foto> fotos = new ArrayList<>();
}
