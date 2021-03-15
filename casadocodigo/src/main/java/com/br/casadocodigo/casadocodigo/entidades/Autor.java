package com.br.casadocodigo.casadocodigo.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	@Size(max=400)
	private String descricao;
	
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	
	public Autor(){
		
	}
	
	public Autor(String nome, String email, String descricao) {
		if(nome==null || nome.trim().equals(""))
		{
			throw new IllegalArgumentException("Não pode ter aluno sem nome");
		}
		else if(email==null || email.trim().equals(""))
		{
			throw new IllegalArgumentException("Não pode ter aluno sem email");
		}
		else if(descricao==null || descricao.trim().equals(""))
		{
			throw new IllegalArgumentException("Não pode ter aluno sem descricao");
		}
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	
	
	

}
