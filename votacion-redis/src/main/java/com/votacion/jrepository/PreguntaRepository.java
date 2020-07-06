package com.votacion.jrepository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.votacion.implement.RepositoryPregunta;
import com.votacion.model.Pregunta;

@Repository
public class PreguntaRepository implements RepositoryPregunta{
	private static final String PRG_KEY = "pregunta";

	private RedisTemplate<String, Pregunta> redisTemplate;

	private HashOperations<String, String, Pregunta> hashOperations;

	public PreguntaRepository(RedisTemplate<String, Pregunta> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<Pregunta> findAll() {
		return hashOperations.values(PRG_KEY);
	}

	@Override
	public Pregunta findById(String id) {
		return (Pregunta) hashOperations.get(PRG_KEY, id);
	}

	@Override
	public void save(Pregunta pregunta) {
		hashOperations.put(PRG_KEY,pregunta.getKey(), pregunta);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(PRG_KEY, id);
	}
}
