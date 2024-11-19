package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Carrera;
import com.example.demo.entity.PlanCarrera;

public interface CarreraDao {
	Carrera create(Carrera a);
	Carrera update(Carrera a);
	void delete(Long id);
	Optional<Carrera>  read(Long id);
	List<Carrera> readAll();
}
