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

import com.br.casadocodigo.casadocodigo.dto.CategoriaDto;
import com.br.casadocodigo.casadocodigo.entidades.Categoria;
import com.br.casadocodigo.casadocodigo.form.CategoriaForm;
import com.br.casadocodigo.casadocodigo.repository.CategoriaRepository;
import com.br.casadocodigo.casadocodigo.validacao.ProibeNomeDuplicadoCategoriaValidator;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

	
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
	
	
	@Transactional
	@PostMapping
	private ResponseEntity<CategoriaDto> cadastrar (@RequestBody @Valid CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder){
		
		Categoria categoria = categoriaForm.converter();
		
		categoriaRepository.save(categoria);
		
		CategoriaDto dto = new CategoriaDto(categoria);
	
		URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@GetMapping("/{id}")
	private ResponseEntity<CategoriaDto> detalhar  (@PathVariable Long id){
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return ResponseEntity.ok(new CategoriaDto(categoria.get()));
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	
	
	
	
}
