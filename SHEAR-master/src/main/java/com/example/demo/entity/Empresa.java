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
@Table(name="empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_empresa")
	private Long id_empresa;
	
	@Column(name="nombre")
private String nombre;
	
	@Column(name="ruc")
private String ruc;
	
	@Column(name="correo")
private String correo;
	
	@Column(name="telefono")
private String telefono;
	
	@Column(name="direccion")
private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "id_representante", nullable = false)
	private RepresentanteLegal representante_legal;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private EstadoPPP estadoPPP;
	
	
	@ManyToOne
	@JoinColumn(name = "id_ubigeo", nullable = false)
	private Ubigeo ubigeo;
	

}
