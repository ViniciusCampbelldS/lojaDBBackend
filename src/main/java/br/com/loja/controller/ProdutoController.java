package br.com.loja.controller;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(produtoDAO.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoDAO.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Produto produto) {
        if (produto.getNome() == null
                || produto.getNome().isBlank()
                || produto.getNome().trim().length() > 100) {
            return ResponseEntity.badRequest()
                    .body("O nome não pode estar em branco nem ter mais de 100 caracteres.");
        }

        BigDecimal preco = produto.getPreco();
        if (preco == null
                || preco.signum() <= 0
                || preco.compareTo(new BigDecimal("9999999999.99")) > 0
                || preco.stripTrailingZeros().scale() > 2) {
            return ResponseEntity.badRequest()
                    .body("Informe um preço positivo até 9999999999.99 com até duas casas decimais.");
        }

        produto.setNome(produto.getNome().trim());
        produtoDAO.inserir(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        if (produto.getNome() == null
                || produto.getNome().isBlank()
                || produto.getNome().trim().length() > 100) {
            return ResponseEntity.badRequest()
                    .body("O nome não pode estar em branco nem ter mais de 100 caracteres.");
        }

        BigDecimal preco = produto.getPreco();
        if (preco == null
                || preco.signum() <= 0
                || preco.compareTo(new BigDecimal("9999999999.99")) > 0
                || preco.stripTrailingZeros().scale() > 2) {
            return ResponseEntity.badRequest()
                    .body("Informe um preço positivo até 9999999999.99 com até duas casas decimais.");
        }

        if (produtoDAO.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produto.setNome(produto.getNome().trim());
        produtoDAO.atualizar(id, produto);
        return ResponseEntity.ok("Produto atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (produtoDAO.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produtoDAO.deletar(id);
        return ResponseEntity.ok("Produto deletado com sucesso.");
    }
}
