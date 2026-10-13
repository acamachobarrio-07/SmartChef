package es.safareyes.smartchef.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosSemanaCalorias {
    private LocalDate dia;
    private String nombreDia;
    private Long totalRecetasCocinadas;
    private Long caloriasTotales;
}