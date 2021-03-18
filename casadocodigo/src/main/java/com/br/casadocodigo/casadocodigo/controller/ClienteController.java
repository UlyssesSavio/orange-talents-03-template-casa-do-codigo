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

import com.br.casadocodigo.casadocodigo.dto.ClienteDto;
import com.br.casadocodigo.casadocodigo.entidades.Cliente;
import com.br.casadocodigo.casadocodigo.form.ClienteForm;
import com.br.casadocodigo.casadocodigo.repository.ClienteRepository;
import com.br.casadocodigo.casadocodigo.repository.EstadoRepository;
import com.br.casadocodigo.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Transactional
	@PostMapping
	private ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {

		Cliente cliente = clienteForm.converter(paisRepository, estadoRepository);

		clienteRepository.save(cliente);

		ClienteDto dto = new ClienteDto(cliente);

		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}

	@GetMapping("/{id}")
	private ResponseEntity<ClienteDto> detalhar(@PathVariable Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		return ResponseEntity.notFound().build();

	}

	
	
}
