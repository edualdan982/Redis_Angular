package com.votacion.jrepository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.votacion.implement.RepositoryPersona;
import com.votacion.model.Persona;

@Repository
public class PersonaRepository implements RepositoryPersona {
	
	private static final String PER_KEY = "persona";

	private RedisTemplate<String, Persona> redisTemplate;
	
	private HashOperations<String, String, Persona> hashOperations;

	
	public PersonaRepository(RedisTemplate<String, Persona> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<Persona> findAll() {
		return hashOperations.values(PER_KEY);		
	}

	@Override
	public Persona findById(String id) {
		return (Persona) hashOperations.get(PER_KEY, id);
	}

	@Override
	public void save(Persona persona) {

		hashOperations.put(PER_KEY, persona.getCi(), persona);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(PER_KEY, id);
	}
}
