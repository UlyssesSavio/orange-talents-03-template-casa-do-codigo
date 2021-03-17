package com.br.casadocodigo.casadocodigo.form;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.br.casadocodigo.casadocodigo.entidades.Autor;
import com.br.casadocodigo.casadocodigo.entidades.Categoria;
import com.br.casadocodigo.casadocodigo.entidades.Livro;
import com.br.casadocodigo.casadocodigo.repository.AutorRepository;
import com.br.casadocodigo.casadocodigo.repository.CategoriaRepository;
import com.br.casadocodigo.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroForm {

	@NotBlank
	@Column(unique = true)
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;

	private String sumario;
	@NotNull
	@DecimalMin("20.0")
	private double preco;
	@NotNull
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Future
	private LocalDate dataLancamento;

	@NotNull
	private Long idCategoria;

	@NotNull
	private Long idAutor;

	public LivroForm() {

	}

	public LivroForm(String titulo, String resumo, String sumario, double preco, int numeroPaginas, String isbn,
			LocalDate dataLancamento, Long idCategoria, Long idAutor) {

		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public double getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		
		@NotNull Optional<Autor> autor = autorRepository.findById(idAutor);
		@NotNull Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);

		
		
		Assert.state(autor.isPresent(),"Você esta querendo cadastrar um livro para um autor que nao existe no banco "+idAutor);
		Assert.state(categoria.isPresent(),"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+idCategoria);

		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataLancamento,
				categoria.get(), autor.get());
	}

}
