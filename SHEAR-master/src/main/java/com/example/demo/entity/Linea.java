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
@Table(name="linea")
public class Linea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_linea")
	private Long id_linea;
	
	@Column(name="nombre")
private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado") // Foreign key que apunta a EstadoPPP
    private EstadoPPP estadoPPP;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "linea")
	@JsonIgnore
	private Set<Practica> practica;
}
