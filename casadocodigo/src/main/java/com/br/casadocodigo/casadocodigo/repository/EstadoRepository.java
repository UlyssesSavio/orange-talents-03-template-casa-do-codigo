package com.br.casadocodigo.casadocodigo.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.br.casadocodigo.casadocodigo.entidades.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Long>{

	List<Estado> findAll();

	Optional<Estado> findByPaisId( Long idPais);
	
}
