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
	@NotEmpty
	private String idCategoria;

	@NotNull
	@NotEmpty
	private String idAutor;

	public LivroForm() {

	}

	public LivroForm(String titulo, String resumo, String sumario, double preco, int numeroPaginas, String isbn,
			LocalDate dataLancamento, String idCategoria, String idAutor) {

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

	public String getIdCategoria() {
		return idCategoria;
	}

	public String getIdAutor() {
		return idAutor;
	}

	public Optional<Livro> converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Optional<Categoria> categoria = categoriaRepository.findById(Long.parseLong(idCategoria));

		Optional<Autor> autor = autorRepository.findById(Long.parseLong(idAutor));
		Optional<Livro> livro;

		if (!categoria.isPresent() || !autor.isPresent()) {
			livro = Optional.empty();
		
		} else {

			livro = Optional.ofNullable(new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataLancamento,
					categoria.get(), autor.get()));

		}

		return livro;
	}

}
