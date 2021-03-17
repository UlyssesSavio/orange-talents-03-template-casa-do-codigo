package com.br.casadocodigo.casadocodigo.dto;

import com.br.casadocodigo.casadocodigo.entidades.Livro;

public class LivroBasicoDto {
	
	
	
	private Long id;
	private String titulo;
	
	
	public LivroBasicoDto() {
		
	}
	
	public LivroBasicoDto(Livro livro) {
		
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public LivroBasicoDto(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	
	

}
