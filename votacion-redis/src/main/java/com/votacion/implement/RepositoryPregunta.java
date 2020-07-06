package com.votacion.implement;

import java.util.List;


import com.votacion.model.Pregunta;



public interface RepositoryPregunta {

	List<Pregunta> findAll();

	Pregunta findById(String id);

	void save(Pregunta perona);

	void delete(String id);
}
