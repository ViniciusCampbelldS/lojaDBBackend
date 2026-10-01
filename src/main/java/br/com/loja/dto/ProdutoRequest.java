package br.com.loja.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

//Esse pedido vem de fora da API (request são dados que vem de fora)
// A resposta sai da API para fora (
public record ProdutoRequest(
    @NotBlank(message = "Informe o nome do produto. ")
    @Size(max = 100)
    String nome,

    @Size(max = 255)
    String descricao,

    @NotNull(message = "Informe o preço. ")
    @DecimalMin(value = "0.00", message = "O preço deve ser no mínimo 0.01. ")
	BigDecimal preco,

    @NotNull(message = "Informe a quantidade. ")
    @Min( value = 0, message = "A quantidade deve ser positiva. ")
    Integer quantidade,

    @NotNull (message = "Informe a categoria")
    Long categoriaId

    ){}
