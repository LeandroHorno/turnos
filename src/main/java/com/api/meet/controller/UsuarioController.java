package com.api.turnos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	Map<String, Object> response = new HashMap<>();
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value="/create")
	public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
		response.clear();
		response.put("Create", usuarioService.save(usuario));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping(value="/read")
	public ResponseEntity<?> getUsers(){
		response.clear();
		response.put("Read", usuarioService.getAll());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public  ResponseEntity<?> updateUser(@RequestBody Usuario usuario) {
		response.clear();
		response.put("Update", usuarioService.update(usuario));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<?> deleteUserById(Optional<Long> usuarioId) {
		response.clear();
		response.put("Delete", usuarioService.deleteById(usuarioId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
