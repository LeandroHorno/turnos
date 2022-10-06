package com.api.turnos.generic;

import java.util.List;

public interface GenericModel <T>{

	
	 List<T> getAll();
	 T getById(Long id);
	 T save(T obje);
	 T deleteById(Long id);
}
