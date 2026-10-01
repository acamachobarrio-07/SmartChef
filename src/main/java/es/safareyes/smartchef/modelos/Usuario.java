package es.safareyes.smartchef.modelos;

//añadimos etiquetas, se la hacemos a spring boot para declarar algo

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

/*La marcamos como tabla*/
@Entity
@Table(name="usuario")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Usuario {


    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Short id;

    @Column(name="nombre", length = 150, nullable=false, unique = true)
    private String nombre;

    @Column(name="rol")
    private Integer rol;

    @Column(name = "contraseña", length = 50, nullable = true)
    private String contraseña;
}
