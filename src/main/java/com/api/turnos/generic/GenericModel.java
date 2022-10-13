package com.api.turnos.generic;

import java.util.List;
import java.util.Optional;



public interface GenericModel <T>{

	
	 List<T> getAll();
	 T getById(Long id);
	 T save(T obje);
	 T deleteById(Optional<Long> id);
	 T update(T obje);
}
