package model;

public class Produto {
	private int id;
	private String name;
	private String descricao;
	private double preco;
	private int quantidade;
	
	// Construtores:
	public Produto(){}
	public Produto(int id, String name, String descricao, double preco, int quantidade) {
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	// Setters:
	public void setID(int i){
		this.id=i;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDescricao(String desc){
		this.descricao=desc;
	}
	public void setPreco(double p){
		this.preco=p;
	}
	public void setQuantidade(int qt){
		this.quantidade=qt;
	}
	
	// Getters:
	public int getID(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getDescricao(){
		return this.descricao;
	}
	public double getPreco(){
		return this.preco;
	}
	public int getQuantidade(){
		return this.quantidade;
	}
	
}
