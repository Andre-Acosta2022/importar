package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Persona;
import com.example.demo.entity.PlanCarrera;

public interface PersonaDao {
	Persona create(Persona a);
	Persona update(Persona a);
	void delete(Long id);
	Optional<Persona>  read(Long id);
	List<Persona> readAll();
}
