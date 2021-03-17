package com.br.casadocodigo.casadocodigo.form;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.br.casadocodigo.casadocodigo.entidades.Pais;
import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;

public class PaisForm {
	

	@NotBlank
	@Column(unique = true)
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public PaisForm() {
		
	}
	
	
	
	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}
	
	
	public Pais converter() {
		return new Pais(nome);
	}
	

}
