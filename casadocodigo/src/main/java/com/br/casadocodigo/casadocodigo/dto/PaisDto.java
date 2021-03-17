package com.br.casadocodigo.casadocodigo.dto;

import com.br.casadocodigo.casadocodigo.entidades.Pais;

public class PaisDto {

	private String nome;

	public PaisDto() {

	}

	public PaisDto(String nome) {
		this.nome = nome;
	}

	public PaisDto(Pais pais) {
		nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}

}
