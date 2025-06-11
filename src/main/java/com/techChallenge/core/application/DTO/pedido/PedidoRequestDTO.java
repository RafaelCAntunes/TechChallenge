package com.techChallenge.core.application.DTO.pedido;

import com.techChallenge.core.application.DTO.itemPedido.ItemPedidoDTO;
import com.techChallenge.core.domain.entity.ItemPedidoEntity;
import com.techChallenge.core.domain.entity.PedidoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Schema(description = "Dados para criar um pedido (checkout)")
public class PedidoRequestDTO {

    @Schema(description = "ID do cliente", example = "3")
    private Long clienteId;

    @Schema(description = "Lista de itens do pedido")
    private List<ItemPedidoDTO> itens;

    public List<ItemPedidoEntity> toItensEntity(PedidoEntity pedido) {
        return itens.stream()
                .map(dto -> {
                    ItemPedidoEntity entity = dto.toEntity();
                    entity.setPedido(pedido); //
                    return entity;
                })
                .collect(Collectors.toList());
    }
}