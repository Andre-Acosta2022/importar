package com.example.demo.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Table(name="tipo_documento")
public class TipoDocumento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_tipo_documento")
	private Long id_tipo_documento;
	
	@Column(name="nombre")
private String nombre;
	
	@Column(name="plantilla_url")
private String plantilla_url;
	
	@ManyToOne
    @JoinColumn(name = "id_rol_emisor", referencedColumnName = "id_rol", nullable = false)
    private Rol rol_emisor;
	
	@ManyToOne
    @JoinColumn(name = "id_rol_receptor", referencedColumnName = "id_rol", nullable = false)
    private Rol rol_receptor;
	
	@ManyToMany(mappedBy = "tipo_documento")
	private Set<PlanCarrera> plan_carrera = new HashSet<>();
}
