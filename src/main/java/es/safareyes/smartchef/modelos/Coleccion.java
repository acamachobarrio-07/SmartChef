package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

/*La marcamos como tabla*/
@Entity
@Table(name="coleccion")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coleccion {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Short id;

    @Column(name="nombre", length = 150, nullable = false, unique = true)
    private String nombre;

    /*para indicar el nombre de las relaciones hay que indicar un objeto dentro de otro*/
    /*hay que ponerle el tipo de relación, se pone en ingles, luego hay que añadir por donde une*/
    /*usamos lazy para cuando el usuario consulte el dato concreto*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coleccion_id_usuario")
    private Usuario usuario;

}
