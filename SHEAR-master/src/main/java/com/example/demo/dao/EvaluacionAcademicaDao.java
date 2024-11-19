package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.EvaluacionAcademica;
import com.example.demo.entity.PlanCarrera;

public interface EvaluacionAcademicaDao {
	EvaluacionAcademica create(EvaluacionAcademica a);
	EvaluacionAcademica update(EvaluacionAcademica a);
	void delete(Long id);
	Optional<EvaluacionAcademica>  read(Long id);
	List<EvaluacionAcademica> readAll();
}
