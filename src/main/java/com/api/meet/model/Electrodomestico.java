package com.api.meet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ELECTRODOMESTICO")
@Data
public class Electrodomestico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long electrodomesticoId;
	@Column
	private String tipo;
	@Column
	private String descripcion;
	
}
