package com.br.casadocodigo.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.br.casadocodigo.casadocodigo.entidades.Autor;
import com.br.casadocodigo.casadocodigo.form.AutorForm;
import com.br.casadocodigo.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm request = (AutorForm) target;
		Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
		if(autor.isPresent()) {
			errors.rejectValue("email", null,"Esse email ja existe: "+request.getEmail());
		}
		
		
	}

	
	
}
