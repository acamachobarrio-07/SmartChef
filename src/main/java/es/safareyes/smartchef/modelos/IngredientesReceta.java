package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ingredientes_receta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"receta", "ingrediente"})
@ToString(exclude = {"receta", "ingrediente"})
public class IngredientesReceta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cantidad")
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredientes", nullable = false)
    private Ingredientes ingrediente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receta", nullable = false)
    private Receta receta;
}
