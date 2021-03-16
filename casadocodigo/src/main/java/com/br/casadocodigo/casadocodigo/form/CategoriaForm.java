package com.br.casadocodigo.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import com.br.casadocodigo.casadocodigo.entidades.Categoria;
import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;

public class CategoriaForm {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName="nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		Categoria categoria = new Categoria(nome);
		return categoria;
	}
	
	

}
