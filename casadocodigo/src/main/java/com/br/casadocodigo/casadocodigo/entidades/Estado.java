package com.br.casadocodigo.casadocodigo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Estado {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	@NotNull
	@ManyToOne
	private Pais pais;
	
	public Estado() {
		
	}
	
	public Estado estadoGenerico( Pais pais, Long id) {
		return new Estado("nao existe", pais, id);
	}
	
	public Estado( String nome,  Pais pais, Long id) {
	
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}
	
	
	public Estado(@NotBlank String nome, @NotBlank Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	

}
