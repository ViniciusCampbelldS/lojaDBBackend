package br.com.loja.model;
import java.math.BigDecimal;

public class Produto {
//	private int id;
	private String nome;
//	private String descricao;
	private BigDecimal preco;
//	private int quantidade;
	
	// Construtores:
	public Produto(){}
	public Produto(String nome, BigDecimal preco) {
//		this.id = id;
		this.nome = nome;
//		this.descricao = descricao;
		this.preco = preco;
//		this.quantidade = quantidade;
	}
	
	// Setters:
/*	public void setId(int id){
		this.id = id;
	}*/
	public void setNome(String nome){
		this.nome = nome;
	}
/*	public void setDescricao(String desc){
		this.descricao=desc;
	}*/
	public void setPreco(BigDecimal p){
		this.preco=p;
	}
/*	public void setQuantidade(int qt){
		this.quantidade=qt;
	}*/
	
	// Getters:
/*	public int getId(){
		return this.id;
	}*/
	public String getNome(){
		return this.nome;
	}
/*	public String getDescricao(){
		return this.descricao;
	}*/
	public BigDecimal getPreco(){
		return this.preco;
	}
/*	public int getQuantidade(){
		return this.quantidade;
	}*/
}
