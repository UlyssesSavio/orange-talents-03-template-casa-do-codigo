package com.br.casadocodigo.casadocodigo.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.casadocodigo.casadocodigo.dto.AutorDto;
import com.br.casadocodigo.casadocodigo.entidades.Autor;
import com.br.casadocodigo.casadocodigo.form.AutorForm;
import com.br.casadocodigo.casadocodigo.repository.AutorRepository;
import com.br.casadocodigo.casadocodigo.validacao.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	
	
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	
	@Transactional
	@PostMapping
	private ResponseEntity<AutorDto> cadastrar (@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
		
		Autor autor = autorForm.converter();
		
		autorRepository.save(autor);
		
		AutorDto dto = new AutorDto(autor);
	
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<AutorDto> detalhar  (@PathVariable Long id){
		
		Optional<Autor> autor = autorRepository.findById(id);
		if(autor.isPresent()) {
			return ResponseEntity.ok(new AutorDto(autor.get()));
		}
		return ResponseEntity.notFound().build();
		
		
	}
	

}
