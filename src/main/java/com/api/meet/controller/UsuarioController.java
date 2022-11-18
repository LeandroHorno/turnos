package com.api.meet.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.meet.exception.ResponseEntityMessage;
import com.api.meet.model.Usuario;
import com.api.meet.service.UsuarioService;

@RestController
@RequestMapping("v1/user")
@CrossOrigin(origins = "http://localhost:4200")
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
	public ResponseEntity<ResponseEntityMessage> deleteUserById(Optional<Long> usuarioId) {
		 usuarioService.getById(usuarioId.get()).orElseThrow(() ->
		 new ResponseStatusException(HttpStatus.NOT_FOUND, "Id" + usuarioId.get() + "No encontrado"));
		 usuarioService.deleteById(usuarioId);
 return new ResponseEntity<ResponseEntityMessage>(new ResponseEntityMessage("Usuario Borrado", usuarioId.get(), "OK"),
			HttpStatus.OK);
}
	}

