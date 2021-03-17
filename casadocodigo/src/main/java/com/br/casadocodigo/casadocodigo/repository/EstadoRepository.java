package com.br.casadocodigo.casadocodigo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.br.casadocodigo.casadocodigo.entidades.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Long>{

	List<Estado> findAll();
	
}
