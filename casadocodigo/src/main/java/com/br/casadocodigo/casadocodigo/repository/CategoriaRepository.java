package com.br.casadocodigo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.br.casadocodigo.casadocodigo.entidades.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);

}
