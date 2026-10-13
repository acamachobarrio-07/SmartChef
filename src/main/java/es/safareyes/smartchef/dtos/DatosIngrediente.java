package es.safareyes.smartchef.dtos;

import es.safareyes.smartchef.modelos.EIngredientesTipoCantidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosIngrediente {

    private String nombre;
    private EIngredientesTipoCantidad tipoCantidad;
    private Integer calorias;
    private Double precio;
}
