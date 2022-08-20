
package arg.com.gym.service;


import arg.com.gym.domain.Persona;
import arg.com.gym.repository.PersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

     @Autowired
     private PersonaRepository personaRepo;
     
     

    @Transactional
    public List<Persona> listAll(String word) {
        if(word != null){
            return personaRepo.findAll(word);
        }
        return (List<Persona>)personaRepo.findAll();
    }


    @Transactional
    public void save(Persona persona) {
       personaRepo.save(persona);
    }

    @Transactional
    public Persona find(Persona persona) {
      return personaRepo.findById(persona.getIdPersona()).orElse(null);
    }
    @Transactional
    public void delete(Persona persona) {
       personaRepo.delete(persona);
    }

    
}
