package br.com.igor.projetosenai.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//NESSA PÁGINA ESTÁ O PACOTE DE "ENTIDADES"


//ESTA ANOTAÇÃO DEFINE A CLASSE COMO ENTIDADE (PARA AUTO CRIAR NO BD UMA TABELA)
@Entity
public class Despesas {

	
// AS 2 ANOTAÇÕES SÃO PARA GERAR ID AUTOMATICO, A PRIMEIRA PARA INDICAR O TIPO
//	A SEGUNDA ESCOLHE O TIPO DE IMPLEMENTAÇÃO DO DADO
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String categoria;
	private double valor;
	private Date data;
//
	
	
	public Despesas() {

	}
	
	public Despesas(Long id, String nome, String categoria, double valor, Date data) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.data = data;
	}

	
//GETTERS AND SETTERS \/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
//
}
