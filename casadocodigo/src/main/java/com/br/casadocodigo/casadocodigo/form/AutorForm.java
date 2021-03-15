package com.br.casadocodigo.casadocodigo.form;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.casadocodigo.casadocodigo.entidades.Autor;

public class AutorForm {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter() {

		Autor autor = new Autor(nome, email, descricao);

		return autor;
	}

}
