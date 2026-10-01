package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Preferencias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreferenciasRepository extends JpaRepository<Preferencias, Integer> {
}
