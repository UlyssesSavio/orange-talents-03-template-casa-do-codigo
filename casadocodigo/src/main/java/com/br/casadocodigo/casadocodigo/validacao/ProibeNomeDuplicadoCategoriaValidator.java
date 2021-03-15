package com.br.casadocodigo.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.br.casadocodigo.casadocodigo.entidades.Autor;
import com.br.casadocodigo.casadocodigo.entidades.Categoria;
import com.br.casadocodigo.casadocodigo.form.CategoriaForm;
import com.br.casadocodigo.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {

		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		CategoriaForm request = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());
		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "Esse nome ja existe: " + request.getNome());
		}

	}

}
