package com.techChallenge.core.application.DTO.produto;

import com.techChallenge.core.domain.entity.ProdutoEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String categoria;

    public ProdutoResponseDTO(ProdutoEntity produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
    }
}
