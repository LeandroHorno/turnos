package com.api.meet.generic;

import java.util.List;
import java.util.Optional;



public interface GenericModel <T>{
	 List<T> getAll();
	 Optional<T> getById(Long id);
	 T save(T obje);
	 void deleteById(Optional<Long> id);
	 T update(T obje);
}
