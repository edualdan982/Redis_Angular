package com.votacion.implement;

import java.util.List;


import com.votacion.model.Persona;

public interface RepositoryPersona {
	List<Persona> findAll();

	Persona findById(String id);

	void save(Persona perona);

	void delete(String id);
}
