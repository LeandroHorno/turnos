package com.api.meet.service.imp;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.meet.model.Usuario;
import com.api.meet.repository.UsuarioRepository;
import com.api.meet.service.UsuarioService;
@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> getById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario obje) {
		return usuarioRepository.save(obje);
	}

	@Override
	public void deleteById(Optional<Long> id) {
		usuarioRepository.deleteById(id.get());
			
			 
	}

	@Override
	public Usuario update(Usuario obje) {
		Usuario user = usuarioRepository.findById(obje.getUsuarioId()).get();
		user.setPassword(obje.getPassword());
		user.setUsuario(obje.getUsuario());
		return user;
	}

}
