package com.techChallenge.core.application.DTO.itemPedido;

import com.techChallenge.core.domain.entity.ItemPedidoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "Item do pedido")
public class ItemPedidoDTO {

    @Schema(description = "ID do produto", example = "2")
    private Long produtoId;

    @Schema(description = "Nome do produto", example = "X-Burguer")
    private String nomeProduto;

    @Schema(description = "Preço unitário do item", example = "19.90")
    private BigDecimal precoUnitario;

    @Schema(description = "Quantidade", example = "2")
    private int quantidade;

    public ItemPedidoEntity toEntity() {
        ItemPedidoEntity entity = new ItemPedidoEntity();
        entity.setProdutoId(produtoId);
        entity.setNomeProduto(nomeProduto);
        entity.setPrecoUnitario(precoUnitario);
        entity.setQuantidade(quantidade);
        return entity;
    }
}