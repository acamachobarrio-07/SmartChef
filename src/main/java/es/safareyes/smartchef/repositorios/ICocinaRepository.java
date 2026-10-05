package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Cocina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICocinaRepository  extends JpaRepository<Cocina, Integer> {

}
