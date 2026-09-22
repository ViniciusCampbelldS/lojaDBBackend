package br.com.loja.model;
import java.math.BigDecimal;
import jakarta.persistence.*;

//JPA é a ORM, JPA usa Hibernate
@Entity
@Table(name="produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false, length = 999)
	private String descricao;
	
	// Construtores:
	public Produto(){}
	public Produto(String nome, BigDecimal preco,  Integer quantidade, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
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
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
}

