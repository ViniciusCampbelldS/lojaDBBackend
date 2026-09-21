package br.com.loja.model;
import java.math.BigDecimal;

public class Produto {
	private Long id;
	private String nome;
	private BigDecimal preco;
	
	// Construtores:
	public Produto(){}
	public Produto(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	// Setters:
	public void setId(Long id){
		this.id = id;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setPreco(BigDecimal p){
		this.preco=p;
	}
	
	// Getters:
	public Long getId(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public BigDecimal getPreco(){
		return this.preco;
	}
}
