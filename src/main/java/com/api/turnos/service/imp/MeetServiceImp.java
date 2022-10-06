package com.api.turnos.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.turnos.model.Meet;
import com.api.turnos.repository.MeetRepository;
import com.api.turnos.service.MeetService;
@Service
public class MeetServiceImp implements MeetService {

	@Autowired
	private MeetRepository meetRepository;
	
	@Override
	public List<Meet> getAll() {
		return (List<Meet>) meetRepository.findAll();
	}

	@Override
	public Meet getById(Long id) {
		return meetRepository.findById(id).orElse(null);
	}

	@Override
	public Meet save(Meet obje) {
		return meetRepository.save(obje);
	}

	@Override
	public Meet deleteById(Long id) {
		try {
			meetRepository.deleteById(id);
			 return meetRepository.findById(id).orElse(null);
		} catch (Exception e) {
			System.out.println("NO EXISTE EL ID: "+id);
		} 
		 return null;
		
	}

}
