package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.PlanCarrera;
import com.example.demo.entity.Rol;

public interface RolDao {
	Rol create(Rol a);
	Rol update(Rol a);
	void delete(Long id);
	Optional<Rol>  read(Long id);
	List<Rol> readAll();
}
