package com.example.demo.entity;

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
@Table(name="documentos_plan")
public class DocumentosPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id_documentos_plan")
	private Long documentos_plan;
	
	
	@ManyToOne
	@JoinColumn(name = "id_plan_carrera", nullable = false)
	private PlanCarrera plan_carrera;
	

	@ManyToOne
	@JoinColumn(name = "id_p", nullable = false)
	private TipoDocumento tipo_documento;
}
