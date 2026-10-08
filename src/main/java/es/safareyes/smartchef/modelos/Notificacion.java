package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

/*La marcamos como tabla*/
@Entity
@Table(name="notificacion")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notificacion {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //ENUM
    @Enumerated
    @Column(name="tipo")
    private ENotificacionTipo eNotificacionTipo;

    @Column(name="texto")
    private String nombre;


}


