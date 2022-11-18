package com.api.meet.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="MEET")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	

	@ManyToOne
	@JoinColumn(name="USUARIO_CREADOR_ID")
	private Usuario usuarioCreadorId;
	
	@ManyToMany
	@JoinTable(name="PARTICIPANTES", joinColumns = @JoinColumn(name="MEET_ID", referencedColumnName = "meet_id"),
	inverseJoinColumns = @JoinColumn(name="USUARIO_ID", referencedColumnName = "usuario_id"))
	private List<Usuario> participantes;
}
