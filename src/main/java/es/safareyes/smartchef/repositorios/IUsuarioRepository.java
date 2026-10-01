package es.safareyes.smartchef.repositorios;

import es.safareyes.smartchef.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
