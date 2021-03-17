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


import com.br.casadocodigo.casadocodigo.dto.EstadoDto;
import com.br.casadocodigo.casadocodigo.entidades.Estado;
import com.br.casadocodigo.casadocodigo.form.EstadoForm;
import com.br.casadocodigo.casadocodigo.repository.EstadoRepository;
import com.br.casadocodigo.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	
	@Transactional
	@PostMapping
	private ResponseEntity<EstadoDto> cadastrar (@RequestBody @Valid  EstadoForm estadoForm, UriComponentsBuilder uriBuilder){
		
		Estado estado = estadoForm.converter(paisRepository);
		
		
		estadoRepository.save(estado);
		
		EstadoDto dto = new EstadoDto(estado);
	
		URI uri = uriBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<EstadoDto> detalhar  (@PathVariable Long id){
		// fiz o metodo de busca desde o inicio
		Optional<Estado> estado = estadoRepository.findById(id);
		if(estado.isPresent()) {
			return ResponseEntity.ok(new EstadoDto(estado.get()));
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	@GetMapping()
	private ResponseEntity<List<EstadoDto>> buscaListaEstado (){
		List<Estado> estados = new ArrayList<Estado>();
		
		estados = estadoRepository.findAll();
		
		List<EstadoDto> estadosDto = new ArrayList<EstadoDto>();
		estadosDto.addAll(estados.stream().map(EstadoDto::new).collect(Collectors.toList()));
		
		
		return ResponseEntity.ok(estadosDto);
		
	}
	

}
