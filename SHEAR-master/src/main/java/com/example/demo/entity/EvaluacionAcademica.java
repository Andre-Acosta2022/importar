package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="evaluacion_academica")
public class EvaluacionAcademica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_evaluacion_academica")
	private Long id_evaluacion;
	
	@Column(name="nombre")
private String nombre;
	
	@Column(name="fecha_evaluacion")
	@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate fecha_evaluacion;
	
	@Column(name="calificacion")
private Double calificacion;
	
	@Column(name="observaciones")
private String observaciones;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_practica", nullable = false)
	private Practica practica;
}
