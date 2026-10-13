package es.safareyes.smartchef.dtos;

import es.safareyes.smartchef.modelos.ERecetaDificultad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosColeccionReceta {
    private String coleccion;
    private String receta;
    private Integer tiempo;
    private ERecetaDificultad dificultad;
}