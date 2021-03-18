package com.br.casadocodigo.casadocodigo.dto;

import com.br.casadocodigo.casadocodigo.entidades.Cliente;
import com.br.casadocodigo.casadocodigo.entidades.Estado;
import com.br.casadocodigo.casadocodigo.entidades.Pais;

public class ClienteDto {

	private String nome;
	private String sobreNome;
	private String email;

	private String cpfCpnj;
	private String endereco;
	private String complemento;
	private String cidade;
	private String cep;
	
	private Pais pais;	
	private Estado estado;
	
	public ClienteDto() {
		
	}
	
	public ClienteDto(String nome, String sobreNome, String email, String cpfCpnj, String endereco, String complemento,
			String cidade, String cep, Pais pais, Estado estado) {
		
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
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.sobreNome = cliente.getSobreNome();
		this.email = cliente.getEmail();
		this.cpfCpnj = cliente.getCpfCpnj();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.cep = cliente.getCep();
		this.pais = cliente.getPais();
		this.estado = cliente.getEstado();
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
