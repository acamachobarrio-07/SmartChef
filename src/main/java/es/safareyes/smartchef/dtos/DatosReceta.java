package es.safareyes.smartchef.dtos;

import es.safareyes.smartchef.modelos.ERecetaDificultad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosReceta {

    private String nombreReceta;
    private Integer tiempo;
    private Double costeEstimado;
    private Integer calorias;
    private ERecetaDificultad dificultad;
    private String preferenciaNombre;


}
