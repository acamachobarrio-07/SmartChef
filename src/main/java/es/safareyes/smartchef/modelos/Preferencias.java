package es.safareyes.smartchef.modelos;

//añadimos etiquetas, se la hacemos a spring boot para declarar algo

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/*La marcamos como tabla*/
@Entity
@Table(name="preferencias")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Preferencias {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="tipo")
    private Integer tipo;

    // N:M usuario_preferencias
    @ManyToMany(mappedBy = "preferencias", fetch = FetchType.LAZY)

    private Set<Usuario> usuarios = new HashSet<>();

    // N:M alergias
    @ManyToMany(mappedBy = "preferenciasAlergias", fetch = FetchType.LAZY)

    private Set<Ingredientes> ingredientesAlergias = new HashSet<>();
}
