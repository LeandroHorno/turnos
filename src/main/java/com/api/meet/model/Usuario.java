package com.api.meet.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@Entity
@Table(name = "USUARIOS")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	private Long usuarioId;

	@Column(name = "USUARIO")
	@NonNull
	private String usuario;
	
	@Column(name = "PASSWORD")
	@NonNull
	private String password;
}
