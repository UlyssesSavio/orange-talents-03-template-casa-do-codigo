package com.br.casadocodigo.casadocodigo.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import com.br.casadocodigo.casadocodigo.entidades.Estado;
import com.br.casadocodigo.casadocodigo.repository.EstadoRepository;
import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;

public class EstadoForm {

	@NotBlank
	private String idPais;

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	public EstadoForm() {

	}

	public EstadoForm(String idPais, String nome) {
		super();
		this.idPais = idPais;
		this.nome = nome;
	}

	public String getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

	public Optional<Estado> converter(EstadoRepository repository) {

		Optional<Estado> estadoOp = repository.findById(Long.parseLong(idPais));

		if (!estadoOp.isPresent()) {
			estadoOp = Optional.empty();
		}

		return estadoOp;

	}

}
