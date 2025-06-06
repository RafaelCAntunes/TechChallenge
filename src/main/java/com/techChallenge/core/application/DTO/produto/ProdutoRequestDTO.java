package com.techChallenge.core.application.DTO.produto;

import com.techChallenge.core.domain.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "Dados para criação ou atualização de produto")
public class ProdutoRequestDTO {

    @Schema(description = "Nome do produto", example = "X-Burguer")
    private String nome;

    @Schema(description = "Descrição detalhada", example = "Pão, carne, queijo e salada")
    private String descricao;

    @Schema(description = "Preço unitário", example = "19.90")
    private BigDecimal preco;

    @Schema(description = "Categoria do produto", example = "LANCHE")
    private String categoria;

    public ProdutoEntity toDomain() {
        return new ProdutoEntity(nome, descricao, categoria, preco);
    }
}
