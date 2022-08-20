
package arg.com.gym.controlador;

import arg.com.gym.domain.Persona;
import arg.com.gym.service.PersonaService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorInicio {
    @Autowired 
    private PersonaService personaService;
    
    @RequestMapping("/")
    public String mostrar(Model model, @Param("word")String word){
        List<Persona> personas = personaService.listAll(word);
        model.addAttribute("personas", personas);
        model.addAttribute("word", word);
        return "index";
    }
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.delete(persona);
        return "redirect:/";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.save(persona);
        return "redirect:/";
    }
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
         persona = personaService.find(persona);
         model.addAttribute("persona", persona);
         return "modificar";
    }
}
