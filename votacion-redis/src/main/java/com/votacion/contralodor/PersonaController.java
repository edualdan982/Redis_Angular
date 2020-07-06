package com.votacion.contralodor;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.votacion.jrepository.PersonaRepository;
import com.votacion.model.Persona;

@RestController
public class PersonaController {
	
    private PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
    	this.personaRepository=personaRepository;
    }

    @GetMapping("/personas")
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @GetMapping("/personas/{id}")
    public Persona findById(@PathVariable String id) {
        return personaRepository.findById(id);
    }

    @PostMapping("/personas")
    public void createStudent(@RequestBody Persona persona) {
        personaRepository.save(persona);
    }

    @DeleteMapping("/personas/{id}")
    public void deleteStudent(@PathVariable String id) {
        personaRepository.delete(id);
    }
}
