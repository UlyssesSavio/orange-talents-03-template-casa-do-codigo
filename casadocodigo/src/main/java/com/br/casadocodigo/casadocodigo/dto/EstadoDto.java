package com.br.casadocodigo.casadocodigo.dto;

import com.br.casadocodigo.casadocodigo.entidades.Estado;
import com.br.casadocodigo.casadocodigo.entidades.Pais;

public class EstadoDto {
	
	private String nome;
	private Pais pais;
	


	public EstadoDto() {
		
	}
	
	public EstadoDto(String nome, Pais pais) {
		
		this.nome = nome;
		this.pais = pais;
	}
	public EstadoDto(Estado estado) {
		nome = estado.getNome();
		pais = estado.getPais();
	}

	public String getNome() {
		return nome;
	}
	public Pais getPais() {
		return pais;
	}
	
	
	

}
