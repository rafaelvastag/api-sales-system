package com.br.rafaelvastag.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.rafaelvastag.model.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository <ClienteEntity, Long>{

}
