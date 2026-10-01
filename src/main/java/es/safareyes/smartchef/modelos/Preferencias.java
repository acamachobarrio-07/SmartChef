package es.safareyes.smartchef.modelos;

//añadimos etiquetas, se la hacemos a spring boot para declarar algo

import jakarta.persistence.*;
import lombok.*;

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
    private Short id;

    @Column(name="tipo")
    private Integer tipo;
}
