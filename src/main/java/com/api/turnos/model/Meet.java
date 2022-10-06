package com.api.turnos.model;

import java.security.Identity;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="MEET")
public class Meet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MEET_ID")
	private Long meetId;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="FECHA")
	private String fecha;
	
	@OneToOne
	private Usuario creador;
	
	@JsonManagedReference
	@OneToMany
	@Column(name="PARTICIPANTES")
	private List<Usuario> participantes;
	
	
	
}
