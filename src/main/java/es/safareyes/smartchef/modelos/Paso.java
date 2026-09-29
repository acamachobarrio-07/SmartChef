package es.safareyes.smartchef.modelos;

//añadimos etiquetas, se la hacemos a spring boot para declarar algo

import jakarta.persistence.*;
import lombok.*;


/*La marcamos como tabla*/
@Entity
@Table(name="paso")
//lombok genera getters, setters, constructor y toString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Paso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Short id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="numero")
    private Integer numero;

    /*para indicar el nombre de las relaciones hay que indicar un objeto dentro de otro*/
    /*hay que ponerle el tipo de relación, se pone en ingles, luego hay que añadir por donde une*/
    /*usamos lazy para cuando el usuario consulte el dato concreto*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paso_id_receta")
    private Receta receta;




}
