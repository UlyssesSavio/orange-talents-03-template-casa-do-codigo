package com.br.casadocodigo.casadocodigo.dto;

import com.br.casadocodigo.casadocodigo.entidades.Categoria;

public class CategoriaDto {
	
	private String nome;
	
	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}
	
	

}
