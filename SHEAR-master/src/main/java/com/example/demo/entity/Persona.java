package com.example.demo.entity;

import java.util.Set;

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
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_persona")
	private Long id_persona;
	
	@Column(name="nombre")
private String nombre;
	
	@Column(name="apellido")
private String apellido;
	
	@Column(name="email")
private String email;
	
	@Column(name="telefono")
private String telefono;
	
	@Column(name="codigo")
private String codigo;
	
	@Column(name="dni")
	private String dni;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private EstadoPPP estadoPPP;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "persona")
	@JsonIgnore
	private Set<Usuario> usuario;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "persona")
	@JsonIgnore
	private Set<Practicante> practicante;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "persona")
	@JsonIgnore
	private Set<RepresentanteLegal> representante_legal;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "persona")
	@JsonIgnore
	private Set<Supervisor> supervisor;
}
