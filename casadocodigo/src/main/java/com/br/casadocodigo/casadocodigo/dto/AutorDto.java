package com.br.casadocodigo.casadocodigo.dto;


import com.br.casadocodigo.casadocodigo.entidades.Autor;

public class AutorDto {
	

	private String nome;
	private String email;
	private String descricao;
	
	public AutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}
	
	

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	
	
	

}
