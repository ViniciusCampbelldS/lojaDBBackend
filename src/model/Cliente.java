package model;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	private String cpf;
	
	// Constructors:
	public Cliente() {}
	public Cliente(int id, String nome, String email, String cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	
	// Setters:
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String eMail) {
		this.email = eMail;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	// Getters:
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCpf() {
		return cpf;
	}
}
