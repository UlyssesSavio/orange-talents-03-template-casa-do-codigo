package com.br.casadocodigo.casadocodigo.controller;

import java.net.URI;
import java.util.Optional;

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

import com.br.casadocodigo.casadocodigo.dto.PaisDto;
import com.br.casadocodigo.casadocodigo.entidades.Pais;
import com.br.casadocodigo.casadocodigo.form.PaisForm;
import com.br.casadocodigo.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@Transactional
	@PostMapping
	private ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm paisForm, UriComponentsBuilder uriBuilder) {

		Pais pais = paisForm.converter();

		paisRepository.save(pais);

		PaisDto dto = new PaisDto(pais);

		URI uri = uriBuilder.path("/pais/{id}").buildAndExpand(pais.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}

	@GetMapping("/{id}")
	private ResponseEntity<PaisDto> detalhar(@PathVariable Long id) {

		Optional<Pais> pais = paisRepository.findById(id);
		if (pais.isPresent()) {
			return ResponseEntity.ok(new PaisDto(pais.get()));
		}
		return ResponseEntity.notFound().build();

	}

}
