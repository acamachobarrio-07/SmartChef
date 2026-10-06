package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*La marcamos como tabla*/
@Entity
@Table(name="despensa")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Despensa {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cantidad")
    private Integer cantidad;

    @Column(name="caducidad")
    private LocalDate caducidad;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredientes", nullable = false)
    private Ingredientes ingrediente;
}
