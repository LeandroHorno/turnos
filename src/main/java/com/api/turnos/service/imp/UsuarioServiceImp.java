package com.api.turnos.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.turnos.model.Usuario;
import com.api.turnos.repository.UsuarioRepository;
import com.api.turnos.service.UsuarioService;
@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario getById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario obje) {
		return usuarioRepository.save(obje);
	}

	@Override
	public Usuario deleteById(Long id) {
		try {
			usuarioRepository.deleteById(id);
			 return usuarioRepository.findById(id).orElse(null);
		} catch (Exception e) {
			System.out.println("NO EXISTE EL ID: "+id);
		} 
		 return null;
	}

}
