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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_usuario")
	private Long id_usuario;
	
	@Column(name="username")
private String username;
	
	@Column(name="password")
private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="estado")
	private String estado;
	
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	
	
	
		
	
	@OneToMany(mappedBy = "usuario_recibe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notificaciones> notificaciones_recibe = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario_envia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notificaciones> notificaciones_envia = new HashSet<>();

	
}
