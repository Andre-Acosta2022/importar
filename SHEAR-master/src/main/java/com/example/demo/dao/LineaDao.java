package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Linea;
import com.example.demo.entity.PlanCarrera;

public interface LineaDao {
	Linea create(Linea a);
	Linea update(Linea a);
	void delete(Long id);
	Optional<Linea>  read(Long id);
	List<Linea> readAll();
}
