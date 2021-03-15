package com.br.casadocodigo.casadocodigo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique = true)
	private String nome;
	
	
	public Categoria (){
		
	}
	
	
	
	public Categoria(String nome) {
		if(nome==null || nome.trim().equals(""))
		{
			throw new IllegalArgumentException("Não pode ter aluno sem nome");
		}
		this.nome = nome;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		
		return nome;
	}
	
	
	
	
}
