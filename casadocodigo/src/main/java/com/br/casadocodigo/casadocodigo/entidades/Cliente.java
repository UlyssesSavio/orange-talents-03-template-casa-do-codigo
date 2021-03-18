package com.br.casadocodigo.casadocodigo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;


@Entity
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobreNome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	
	@NotBlank
	@Column(unique=true)
	private String cpfCpnj;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;
	
	
	@NotNull
	@ManyToOne
	private Pais pais;

	
	@ManyToOne
	private Estado estado;


	public Cliente() {
		
	}
	

	public Cliente(@NotBlank String nome, @NotBlank String sobreNome, @NotBlank @Email String email,
			@NotBlank String cpfCpnj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotBlank String cep, @NotNull Pais pais, Estado estado) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cpfCpnj = cpfCpnj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.pais = pais;
		this.estado = estado;
	}



	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public String getSobreNome() {
		return sobreNome;
	}



	public String getEmail() {
		return email;
	}



	public String getCpfCpnj() {
		return cpfCpnj;
	}



	public String getEndereco() {
		return endereco;
	}



	public String getComplemento() {
		return complemento;
	}



	public String getCidade() {
		return cidade;
	}



	public String getCep() {
		return cep;
	}



	public Pais getPais() {
		return pais;
	}



	public Estado getEstado() {
		return estado;
	}
	

	
	

}
