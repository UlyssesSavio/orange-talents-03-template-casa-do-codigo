package com.br.casadocodigo.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import com.br.casadocodigo.casadocodigo.entidades.Categoria;

public class CategoriaForm {
	
	@NotBlank
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
