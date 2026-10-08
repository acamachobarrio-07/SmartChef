package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/*La marcamos como tabla*/
@Entity
@Table(name="ingredientes")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
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