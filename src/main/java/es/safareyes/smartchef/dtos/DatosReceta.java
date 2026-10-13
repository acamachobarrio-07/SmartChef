package es.safareyes.smartchef.dtos;

import es.safareyes.smartchef.modelos.ERecetaDificultad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosReceta {

    private String nombre;
    private Integer raciones;
    private Integer tiempo;
    private Integer calorias;
    private String descripcion;
    private ERecetaDificultad eRecetaDificultad;

}
