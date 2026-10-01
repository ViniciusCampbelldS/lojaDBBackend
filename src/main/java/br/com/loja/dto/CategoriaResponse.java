package br.com.loja.dto;

import br.com.loja.model.Categoria;

//record é gravação de dados / transporte de dados
// DTO é Data Transport Object
public record CategoriaResponse (
    Long id,
    String nome,
    String descricao
){
    public static CategoriaResponse from (Categoria categoria){
        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}