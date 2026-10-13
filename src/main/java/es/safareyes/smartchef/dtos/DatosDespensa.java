package es.safareyes.smartchef.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosDespensa {
    private String ingrediente;
    private Integer cantidad;
    private LocalDate caducidad;

}
