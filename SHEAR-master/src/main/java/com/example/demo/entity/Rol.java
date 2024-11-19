package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name="rol")
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_rol")
	private Long id_rol;
	
	@Column(name="nombre")
private String nombre;
	
	@Column(name="estado")
private String estado;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "rol")
	@JsonIgnore
	private Set<RolAcceso> rol_acceso;
	

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "rol")
	@JsonIgnore
	private Set<UsuarioRol> usuario_rol;
	
	
	@OneToMany(mappedBy = "rol_emisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TipoDocumento> documento_emisor = new HashSet<>();
	
	@OneToMany(mappedBy = "rol_receptor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TipoDocumento> documento_receptor = new HashSet<>();
	
	
}
