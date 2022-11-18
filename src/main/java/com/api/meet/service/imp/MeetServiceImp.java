package com.api.meet.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.meet.model.Meet;
import com.api.meet.repository.MeetRepository;
import com.api.meet.service.MeetService;
@Service
public class MeetServiceImp implements MeetService {

	@Autowired
	private MeetRepository meetRepository;
	
	@Override
	public List<Meet> getAll() {
		return (List<Meet>) meetRepository.findAll();
	}

	@Override
	public Optional<Meet> getById(Long id) {
		return meetRepository.findById(id);
	}

	@Override
	public Meet save(Meet obje) {
		obje.setUsuarioCreadorId(null);
		return meetRepository.save(obje);
	}

	@Override
	public void deleteById(Optional<Long> id) {
		meetRepository.deleteById(id.get());
	}

	@Override
	public Meet update(Meet obje) {
		Meet meet = meetRepository.findById(obje.getMeetId()).get();
		meet.setFecha(obje.getFecha());
		return meetRepository.save(meet);
	}


}
