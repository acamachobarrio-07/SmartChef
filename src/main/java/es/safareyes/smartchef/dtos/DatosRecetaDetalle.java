package es.safareyes.smartchef.dtos;

import es.safareyes.smartchef.modelos.ERecetaDificultad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRecetaDetalle {
    private Integer recetaId;
    private String recetaNombre;
    private Integer calorias;
    private Integer tiempo;
    private ERecetaDificultad eRecetaDificultad;
    private String descripcion;
    private String ingredientes;
    private String pasos;
}