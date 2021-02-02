package com.br.rafaelvastag.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.rafaelvastag.exception.UsuarioCadastradoException;
import com.br.rafaelvastag.model.entity.UsuarioEntity;
import com.br.rafaelvastag.model.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioEntity usuario = repository
												.findByUsername(username)
												.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));
		
		return User.builder()
							.username(usuario.getUsername())
							.password(usuario.getPassword())
							.roles("USER")
							.build();
	}

	public UsuarioEntity salvar(@Valid UsuarioEntity usuario) {
		boolean exists = repository.existsByUsername(usuario.getUsername());
		
		if (exists) {
			throw new UsuarioCadastradoException(usuario.getUsername());
		}
		
		return repository.save(usuario);
	}

}
