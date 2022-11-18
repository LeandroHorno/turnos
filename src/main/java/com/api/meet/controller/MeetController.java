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
import com.api.meet.model.Meet;
import com.api.meet.model.Usuario;
import com.api.meet.service.MeetService;

@RestController
@RequestMapping("v1/meet")
@CrossOrigin(origins = "http://localhost:4200")
public class MeetController {
	@Autowired
	private MeetService meetService;
	
	Map<String, Object> response = new HashMap<>();
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody Meet meet, Usuario user) {
		response.clear();
		meet.setUsuarioCreadorId(user);
		response.put("Create",meetService.save(meet));
		return new ResponseEntity<> (response, HttpStatus.OK);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> getAll(){
		response.clear();
		response.put("Read", meetService.getAll());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Meet meet){
		response.clear();
		response.put("Update", meetService.update(meet));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseEntityMessage> delete(Optional<Long> meetId){
		  meetService.getById(meetId.get()).orElseThrow(() ->
				 new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el id" + meetId.get()));
		 meetService.deleteById(meetId);
		 return new ResponseEntity<ResponseEntityMessage>(new ResponseEntityMessage("Meet Borrada", meetId.get(), "OK"),
					HttpStatus.OK);
	}
	
//	@PutMapping("/addUser")
//	public ResponseEntity<?> delete(Optional<Long> meetId){
//		response.clear();
//		response.put("Delete", meetService.deleteById(meetId));
//		return new ResponseEntity<>(response,HttpStatus.OK);
//	}
	
}
