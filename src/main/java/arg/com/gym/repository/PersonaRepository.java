
package arg.com.gym.repository;

import arg.com.gym.domain.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    @Query("SELECT p FROM Persona p WHERE"
            + " CONCAT(p.nombre,p.dni,p.apellido)"
            + "LIKE %?1%")
    public List<Persona> findAll(String word);
}
