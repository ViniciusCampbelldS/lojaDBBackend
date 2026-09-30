package br.com.loja.model;
import java.math.BigDecimal;
import jakarta.persistence.*;

//JPA é a ORM, JPA usa Hibernate
@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 255)
	private String descricao;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;

	@Column(nullable = false)
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	// Construtores:
	public Produto() {
	}

	public Produto(String nome, String descricao, BigDecimal preco,
				   Integer quantidade, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}

	// Setters:
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Getters:
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public Categoria getCategoria() {
		return categoria;
	}
}