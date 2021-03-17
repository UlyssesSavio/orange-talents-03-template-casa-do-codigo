package com.br.casadocodigo.casadocodigo.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.br.casadocodigo.casadocodigo.entidades.Estado;
import com.br.casadocodigo.casadocodigo.entidades.Pais;
import com.br.casadocodigo.casadocodigo.repository.PaisRepository;
import com.br.casadocodigo.casadocodigo.validacao.ExistsId;
import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;

public class EstadoForm {

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	public EstadoForm() {

	}

	public EstadoForm(Long idPais, String nome) {
		
		this.idPais = idPais;
		this.nome = nome;
	}

	

	public Long getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

	public Estado converter(PaisRepository repository) {

		Optional<Pais> paisOp = repository.findById(idPais);

		Assert.state(paisOp.isPresent(),"Nao existe o pais com o id "+idPais);
		
		
		
		return new Estado(nome, paisOp.get());

	}

}
