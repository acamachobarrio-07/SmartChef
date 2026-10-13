package es.safareyes.smartchef.modelos;

import es.safareyes.smartchef.repositorios.IIngredientesRecetaRepository;
import es.safareyes.smartchef.repositorios.IIngredientesRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*La marcamos como tabla*/
@Entity
@Table(name="ingredientes")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"alergias", "usuariosListaCompra", "ingredientesReceta", "despensas"})
@ToString(exclude = {"alergias", "usuariosListaCompra", "ingredientesReceta", "despensas"})
public class Ingredientes {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", length = 150, nullable = false, unique = true)
    private String nombre;

    //ENUM
    @Enumerated
    @Column(name="tipo_cantidad")
    private EIngredientesTipoCantidad eIngredientesTipoCantidad;

    @Column(name="calorias")
    private Integer calorias;

    @Column(name="precio")
    private Integer precio;

    //N:M alergias
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "alergias",
            joinColumns = @JoinColumn(name = "id_ingredientes"),
            inverseJoinColumns = @JoinColumn(name = "id_preferencias")
    )

    private Set<Preferencias> alergias = new HashSet<>();

    // N:M lista_compra
    @ManyToMany(mappedBy = "listaCompra", fetch = FetchType.LAZY)
    private Set<Usuario> usuariosListaCompra = new HashSet<>();

}