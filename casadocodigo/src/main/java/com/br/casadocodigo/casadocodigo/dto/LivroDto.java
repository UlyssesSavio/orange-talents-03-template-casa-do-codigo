package com.br.casadocodigo.casadocodigo.dto;

import java.time.LocalDate;

import com.br.casadocodigo.casadocodigo.entidades.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroDto {
	//Livro dto que ja tinha criado

	private String titulo;
	private String resumo;
	private String sumario;
	private double preco;
	private int numeroPaginas;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;

	private AutorDto autorDto;
	private CategoriaDto categoriaDto;

	public LivroDto(String titulo, String resumo, String sumario, double preco, int numeroPaginas,
			LocalDate dataLancamento) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.dataLancamento = dataLancamento;
	}

	public LivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.dataLancamento = livro.getDataLancamento();
		autorDto = new AutorDto(livro.getAutor());
		categoriaDto = new CategoriaDto(livro.getCategoria());
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

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public AutorDto getAutorDto() {
		return autorDto;
	}

	public CategoriaDto getCategoriaDto() {
		return categoriaDto;
	}

}
