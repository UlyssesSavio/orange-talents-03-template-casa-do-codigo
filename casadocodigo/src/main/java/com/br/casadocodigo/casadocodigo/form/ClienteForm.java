package com.br.casadocodigo.casadocodigo.form;

import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import com.br.casadocodigo.casadocodigo.entidades.Cliente;
import com.br.casadocodigo.casadocodigo.entidades.Estado;
import com.br.casadocodigo.casadocodigo.entidades.Pais;
import com.br.casadocodigo.casadocodigo.repository.EstadoRepository;
import com.br.casadocodigo.casadocodigo.repository.PaisRepository;
import com.br.casadocodigo.casadocodigo.validacao.CpfCnpj;
import com.br.casadocodigo.casadocodigo.validacao.ExistsId;
import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;

public class ClienteForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobreNome;
	@NotBlank
	@Email
	@Column(unique = true)
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfCpnj")
	@CpfCnpj
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
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	private Long idEstado = 0L;

	public ClienteForm() {

	}


	
	
	public ClienteForm(@NotBlank String nome, @NotBlank String sobreNome, @NotBlank @Email String email,
			@NotBlank String cpfCpnj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotBlank String cep, @NotNull Long idPais, Long idEstado) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cpfCpnj = cpfCpnj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
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

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepostory) {
		Optional<Estado> estadoOp = Optional.empty();
		Optional<Pais> paisOp = paisRepository.findById(idPais);
		Assert.state(paisOp.isPresent(), "id de pais invalido");

		Estado estado = new Estado();
		Pais pais = paisOp.get();

		if (idEstado != 0 || idEstado >= 1) {
			estadoOp = estadoRepostory.findById(idEstado);
			Assert.state(estadoOp.isPresent(), "id de estado invalido");
			estado = estadoOp.get();
		}

		else if (estadoOp.isEmpty()) {

			estadoOp = estadoRepostory.findByPaisId(idPais);
			Assert.state(!estadoOp.isPresent(), "o pais tem estados disponiveis");
			estado = null;
		}

		return new Cliente(nome, sobreNome, email, cpfCpnj, endereco, complemento, cidade, cep, pais, estado);

	}

}
