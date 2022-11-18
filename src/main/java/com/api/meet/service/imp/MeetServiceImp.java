package com.api.turnos.service.imp;

import java.util.List;
import java.util.Optional;

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
	public Meet deleteById(Optional<Long> id) {
		try {
			meetRepository.deleteById(id.get());
			 return meetRepository.findById(id.get()).get();
		} catch (Exception e) {
			System.out.println("NO EXISTE EL ID: "+id);
		} 
		 return null;
		
	}

	@Override
	public Meet update(Meet obje) {
		Meet meet = meetRepository.findById(obje.getMeetId()).get();
		meet.setFecha(obje.getFecha());
		return meetRepository.save(meet);
	}


}
