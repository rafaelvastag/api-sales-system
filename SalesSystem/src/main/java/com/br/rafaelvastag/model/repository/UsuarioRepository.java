package com.br.rafaelvastag.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.rafaelvastag.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
	
	Optional<UsuarioEntity> findByUsername(String username);
	
	boolean existsByUsername(String username);

}
