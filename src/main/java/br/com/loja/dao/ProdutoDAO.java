package br.com.loja.dao;
import br.com.loja.model.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	// Injeção de Dependência via Construtor
	public ProdutoDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// RowMapper: Mapeia apenas as colunas que sua classe possui
	private final RowMapper<Produto> produtoRowMapper = (rs, rowNum) -> {
		Produto produto = new Produto();
		produto.setId(rs.getLong("id"));
		produto.setNome(rs.getString("nome"));
		produto.setPreco(rs.getBigDecimal("preco"));
		return produto;
	};
	
	// 1. CREATE (Inserir)
	public void inserir(Produto produto) {
		String sql = """
                INSERT INTO produto (nome, preco) VALUES (?, ?)
                """;
		jdbcTemplate.update(sql, produto.getNome(), produto.getPreco());
	}
	
	// 2. READ ALL (Buscar Todos)
	public List<Produto> buscarTodos() {
		String sql = """
                SELECT id, nome, preco FROM produto
                """;
		return jdbcTemplate.query(sql, produtoRowMapper);
	}
	
	// 3. READ BY ID (Buscar por ID)
	public Optional<Produto> buscarPorId(Long id) {
		String sql = """
                SELECT id, nome, preco FROM produto WHERE id = ?
                """;
		List<Produto> produtos = jdbcTemplate.query(sql, produtoRowMapper, id);
		return produtos.stream().findFirst();
	}
	
	// 4. UPDATE (Atualizar)
	// Como a classe não tem ID, passamos o ID da tabela explicitamente no parâmetro
	public void atualizar(Long id, Produto produto) {
		String sql = """
                UPDATE produto
                SET nome = ?, preco = ?
                WHERE id = ?
                """;
		jdbcTemplate.update(sql, produto.getNome(), produto.getPreco(), id);
	}
	
	// 5. DELETE (Deletar)
	public void deletar(Long id) {
		String sql = """
                DELETE FROM produto WHERE id = ?
                """;
		jdbcTemplate.update(sql, id);
	}
}
