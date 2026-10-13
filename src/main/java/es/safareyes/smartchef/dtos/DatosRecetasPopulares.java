package es.safareyes.smartchef.dtos;

import es.safareyes.smartchef.modelos.ERecetaDificultad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRecetasPopulares {

    private String nombre;
    private ERecetaDificultad eRecetaDificultad;
    private Integer tiempo;
    private Long totalCocinados;
    private Long totalGuardados;
}