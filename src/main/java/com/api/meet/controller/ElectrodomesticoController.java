package com.api.meet.controller;

import java.util.HashMap;
import java.util.List;
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
import com.api.meet.model.Electrodomestico;
import com.api.meet.service.ElectrodomesticoService;

@RestController
@RequestMapping("v1/electrodomesticos")
@CrossOrigin(origins = "http://localhost:4200")
public class ElectrodomesticoController {
	@Autowired
	private ElectrodomesticoService electrodomesticoService;
	Map<String, Object> response = new HashMap<>();

	@PostMapping(value = "/create")
	public ResponseEntity<?> createUser(@RequestBody Electrodomestico electrodomestico) {
		response.clear();
		response.put("data", electrodomesticoService.save(electrodomestico));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/read")
	public ResponseEntity<?> getUsers() {
		response.clear();
		response.put("data", electrodomesticoService.getAll());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/leer")
	public List<Electrodomestico> getUser() {
		return electrodomesticoService.getAll();
	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> updateUser(@RequestBody Electrodomestico electrodomestico) {
		response.clear();
		response.put("data", electrodomesticoService.update(electrodomestico));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<ResponseEntityMessage> deleteUserById(Optional<Long> id) {
		electrodomesticoService.getById(id.get()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id" + id.get() + "No encontrado"));
		electrodomesticoService.deleteById(id);
		return new ResponseEntity<ResponseEntityMessage>(new ResponseEntityMessage("Usuario Borrado", id.get(), "OK"),
				HttpStatus.OK);
	}
}
