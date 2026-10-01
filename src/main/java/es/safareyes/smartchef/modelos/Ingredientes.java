package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;

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
    private Short id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="tiempo")
    private Integer tiempo;

    @Column(name="tipo_cantidad")
    private Integer tipoCantidad;

    @Column(name="calorias")
    private Integer calorias;

    @Column(name="precio")
    private Integer precio;


}

