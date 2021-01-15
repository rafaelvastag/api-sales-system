package com.br.rafaelvastag.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.rafaelvastag.model.entity.ServicoEntity;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long>{

	@Query("select s from ServicoEntity s join s.cliente c "
					+ "where upper( c.nome ) like upper( :nome ) and MONTH( s.data ) = :mes")
	List<ServicoEntity> findByCustomerNameAndMonth(
				@Param("nome") String nome, 
				@Param("mes") Integer mes);

}
