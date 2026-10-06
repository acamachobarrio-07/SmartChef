package es.safareyes.smartchef.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

/*La marcamos como tabla*/
@Entity
@Table(name="foto")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Foto {

    //atributos
    /*declaramos la id y tambien la ponemos como autoincrement*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "url_imagen", length = 500, nullable = false)
    private String urlImagen;

    /*para indicar el nombre de las relaciones hay que indicar un objeto dentro de otro*/
    /*hay que ponerle el tipo de relación, se pone en ingles, luego hay que añadir por donde une*/
    /*usamos lazy para cuando el usuario consulte el dato concreto*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_receta")
    private Receta receta;



}


