package br.com.loja.service;

import br.com.loja.form.ProdutoForm;
import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import br.com.loja.repository.ProdutoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService;

    public ProdutoService(ProdutoRepository produtoRepository,
                          CategoriaService categoriaService) {
        this.produtoRepository = produtoRepository;
        this.categoriaService = categoriaService;
    }

    @Transactional(readOnly = true)
    public List<Produto> listar() {
        return produtoRepository.findAll(Sort.by("nome").ascending());
    }

    @Transactional(readOnly = true)
    public Produto buscar(Long id) {
        return produtoRepository.buscarComCategoria(id)
            .orElseThrow(() -> new RegistroNaoEncontradoException(
                "Produto não encontrado."
            ));
    }

    @Transactional
    public Produto salvar(ProdutoForm form) {
        Categoria categoria = categoriaService.buscar(form.getCategoriaId());

        Produto produto = form.getId() == null
            ? new Produto()
            : buscar(form.getId());

        produto.setNome(form.getNome().trim());
        produto.setDescricao(form.getDescricao());
        produto.setPreco(form.getPreco());
        produto.setQuantidade(form.getQuantidade());
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    @Transactional
    public void excluir(Long id) {
        buscar(id);
        produtoRepository.deleteById(id);
    }
}
