package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="practica")
public class Practica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_practica")
	private Long id_practica;
	
	
	@Column(name="fecha_inicio")
	@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate fecha_inicio;
	
	@Column(name="fecha_fin")
	@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate fecha_fin;
	
	@Column(name="horas_plan")
private String horas_plan;
	
	@Column(name="nota_academica")
private Number nota_academica;
	
	@Column(name="nota_empresarial")
private Number nota_empresarial;
	
	@Column(name="ponderado_final")
	private Number ponderado_final;
	
	
	@ManyToOne
	@JoinColumn(name = "id_linea", nullable = false)
	private Linea linea;
	
	@ManyToOne
	@JoinColumn(name = "id_supervisor", nullable = false)
	private Supervisor supervisor;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private EstadoPPP estadoPPP;
	
	@ManyToOne
	@JoinColumn(name = "id_plan_carrera", nullable = false)
	private PlanCarrera plan_carrera;
	
	@ManyToOne
	@JoinColumn(name = "id_practicante", nullable = false)
	private Practicante practicante;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "practica")
	@JsonIgnore
	private Set<EvaluacionAcademica> evaluacion_academica;
	
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private EstadoPPP empresa;
	
	
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "practica")
	@JsonIgnore
	private Set<Documentacion> documentacion;
	
	
	// Setter para nota_academica
	public void setNota_academica(Number nota_academica) {
	    this.nota_academica = nota_academica;
	    calcularPonderadoFinal();
	}

	// Setter para nota_empresarial
	public void setNota_empresarial(Number nota_empresarial) {
	    this.nota_empresarial = nota_empresarial;
	    calcularPonderadoFinal();
	}


	private void calcularPonderadoFinal() {
	    if (nota_academica != null && nota_empresarial != null) {
	        
	    	
	        Double promedio = (nota_academica.doubleValue() + nota_empresarial.doubleValue()) / 2;
	        this.ponderado_final = promedio;
	    } else {
	        this.ponderado_final = null;
	    }
	}
	
	
}
