package com.api.meet.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.meet.model.Electrodomestico;
import com.api.meet.repository.ElectrodomesticoRepository;
import com.api.meet.service.ElectrodomesticoService;
@Service
public class ElectrodomesticoServiceImp implements ElectrodomesticoService{
	@Autowired
	private ElectrodomesticoRepository electrodomesticoRepository;
	
	
	@Override
	public List<Electrodomestico> getAll() {
		return (List<Electrodomestico>) electrodomesticoRepository.findAll();
	}

	@Override
	public Optional<Electrodomestico> getById(Long id) {
		return electrodomesticoRepository.findById(id);
	}

	@Override
	public Electrodomestico save(Electrodomestico obje) {
		return electrodomesticoRepository.save(obje);
	}

	@Override
	public void deleteById(Optional<Long> id) {
		electrodomesticoRepository.deleteById(id.get());
	}

	@Override
	public Electrodomestico update(Electrodomestico obje) {
		return electrodomesticoRepository.save(obje);
	}
}
