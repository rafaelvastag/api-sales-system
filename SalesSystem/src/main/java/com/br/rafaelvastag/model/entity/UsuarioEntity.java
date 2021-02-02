package com.br.rafaelvastag.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, name = "user_login")
	@NotEmpty(message = "{campo.login.obrigatorio}")
	private String username;
	
	@Column(name = "user_password")
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String password;

}
