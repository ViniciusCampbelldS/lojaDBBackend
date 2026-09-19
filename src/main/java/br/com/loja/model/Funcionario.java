package br.com.loja.model;

public class Funcionario {
	private int id;
	private String name;
	private String funcao;
	private String cpf;
	private double salario;
	
	public Funcionario() {	}
	public Funcionario(int id, String name, String funcao, String cpf, double salario) {
		this.id = id;
		this.name = name;
		this.funcao = funcao;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	//getters
	public double getSalario() {
		return salario;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	//setters
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
