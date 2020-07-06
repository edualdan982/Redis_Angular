package com.votacion.contralodor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.votacion.jrepository.PreguntaRepository;
import com.votacion.model.Pregunta;
import com.votacion.seq.Secuencia;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
public class PreguntaController {
	private static final String PRG_KEY = "pregunta";

    private PreguntaRepository preguntaRepository;

    public PreguntaController(PreguntaRepository preguntaRepository) {
    	this.preguntaRepository=preguntaRepository;
    }

    @GetMapping("/preguntas")
    public List<Pregunta> findAll() {
        return preguntaRepository.findAll();
    }

    @GetMapping("/preguntas/{id}")
    public Pregunta findById(@PathVariable String id) {
        return preguntaRepository.findById(id);
    }

    @PostMapping("/preguntas")
    public void createStudent(@RequestBody Pregunta pregunta) {
		Secuencia seq = new Secuencia();
		String s = seq.setSeqPregunta();
		pregunta.setKey(PRG_KEY+":"+s);
        preguntaRepository.save(pregunta);
    }
    
    @PutMapping("/preguntas/{key}")
    public void update(@PathVariable String key, @RequestBody Pregunta p) {
    	Pregunta pnew = new Pregunta();
    	pnew = preguntaRepository.findById(key);
    	pnew.setKey(key);
    	pnew.setContenido(p.getContenido());
    	pnew.setTipo(p.getTipo());
    	preguntaRepository.save(pnew);
    	
    }
    @DeleteMapping("/preguntas/{id}")
    public void deleteStudent(@PathVariable String id) {
        preguntaRepository.delete(id);
    }

}
