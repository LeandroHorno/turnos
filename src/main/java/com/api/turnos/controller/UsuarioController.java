package com.api.turnos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.turnos.model.Usuario;
import com.api.turnos.service.UsuarioService;

@RestController
@RequestMapping("/v1/user")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value="/create")
	public Usuario createUser(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return usuario;
	}
	@GetMapping(value="/read")
	public List<Usuario> getUsers(){
		return usuarioService.getAll();
	}
	
	@PutMapping(value="/update")
	public Usuario updateUser(@RequestBody Usuario usuario) {
		Usuario user = usuarioService.getById(usuario.getUsuarioId());
		user.setPassword(usuario.getPassword());
		user.setUsuario(usuario.getUsuario());
		usuarioService.save(user);
		return user;
	}
	
	@DeleteMapping(value="/delete")
	public Usuario deleteUserById(Optional<Long> usuarioId) {
		usuarioService.deleteById(usuarioId.get());
		return usuarioService.getById(usuarioId.get());
	}
}
