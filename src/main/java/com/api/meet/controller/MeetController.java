package com.api.turnos.controller;

import java.util.HashMap;
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

import com.api.turnos.model.Meet;
import com.api.turnos.service.MeetService;

@RestController
@RequestMapping("v1/meet")
public class MeetController {
	@Autowired
	private MeetService meetService;
	
	Map<String, Object> response = new HashMap<>();
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody Meet meet) {
		response.clear();
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
	public ResponseEntity<?> delete(Optional<Long> meetId){
		response.clear();
		response.put("Delete", meetService.deleteById(meetId));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
