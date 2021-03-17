package com.br.casadocodigo.casadocodigo.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique = true)
	private String titulo;
	@NotBlank
	@Size(max=500)
	private String resumo;
	
	private String sumario;
	@NotNull
	@DecimalMin("20.0")
	private double preco;
	@NotNull
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@NotNull
	@ManyToOne
	private Autor autor;
	
	
	public Livro() {
		
	}
	
	
	
	
	public Livro(String titulo, String resumo, String sumario,
			double preco, int numeroPaginas, String isbn,
			LocalDate dataLancamento, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}




	public Long getId() {
		return id;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public Autor getAutor() {
		return autor;
	}
	
	
	

}
