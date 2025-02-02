package com.br.casadocodigo.casadocodigo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.casadocodigo.casadocodigo.dto.LivroBasicoDto;
import com.br.casadocodigo.casadocodigo.dto.LivroDto;
import com.br.casadocodigo.casadocodigo.entidades.Livro;
import com.br.casadocodigo.casadocodigo.form.LivroForm;
import com.br.casadocodigo.casadocodigo.repository.AutorRepository;
import com.br.casadocodigo.casadocodigo.repository.CategoriaRepository;
import com.br.casadocodigo.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	
	@Transactional
	@PostMapping
	private ResponseEntity<LivroDto> cadastrar (@RequestBody @Valid  LivroForm livroForm, UriComponentsBuilder uriBuilder){
		
		Livro livro = livroForm.converter(categoriaRepository, autorRepository);
	
		
		livroRepository.save(livro);
		
		LivroDto dto = new LivroDto(livro);
	
		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<LivroDto> detalhar  (@PathVariable Long id){
		// fiz o metodo de busca desde o inicio
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent()) {
			return ResponseEntity.ok(new LivroDto(livro.get()));
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	@GetMapping()
	private ResponseEntity<List<LivroBasicoDto>> buscaListaLivro (){
		List<Livro> livros = new ArrayList<Livro>();
		
		livros = livroRepository.findAll();
		
		List<LivroBasicoDto> livrosDto = new ArrayList<LivroBasicoDto>();
		livrosDto.addAll(livros.stream().map(LivroBasicoDto::new).collect(Collectors.toList()));
		
		
		return ResponseEntity.ok(livrosDto);
		
	}

}
