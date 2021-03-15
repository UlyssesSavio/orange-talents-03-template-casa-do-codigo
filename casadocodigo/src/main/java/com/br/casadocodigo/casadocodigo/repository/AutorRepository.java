package com.br.casadocodigo.casadocodigo.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.br.casadocodigo.casadocodigo.entidades.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}
