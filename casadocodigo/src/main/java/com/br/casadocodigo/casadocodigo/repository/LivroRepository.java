package com.br.casadocodigo.casadocodigo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.br.casadocodigo.casadocodigo.entidades.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long>{

	
	List<Livro> findAll();
}
