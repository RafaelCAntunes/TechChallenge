package com.techChallenge.core.application.DTO.pedido;

import com.techChallenge.core.application.DTO.itemPedido.ItemPedidoDTO;
import com.techChallenge.core.domain.entity.PedidoEntity;
import com.techChallenge.core.domain.enums.StatusPedido;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private String status;
    private List<ItemPedidoDTO> itens;
    private long tempoDeEsperaEmMinutos;

    public PedidoResponseDTO(PedidoEntity pedido) {
        this.id = pedido.getId();
        this.clienteId = pedido.getClienteId();
        this.status = pedido.getStatus();
        this.tempoDeEsperaEmMinutos = calcularTempoEspera(pedido);

        this.itens = pedido.getItens().stream()
                .map(item -> {
                    ItemPedidoDTO dto = new ItemPedidoDTO();
                    dto.setProdutoId(item.getProdutoId());
                    dto.setNomeProduto(item.getNomeProduto());
                    dto.setPrecoUnitario(item.getPrecoUnitario());
                    dto.setQuantidade(item.getQuantidade());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private long calcularTempoEspera(PedidoEntity pedido) {
        return java.time.Duration.between(pedido.getCriadoEm(), java.time.LocalDateTime.now()).toMinutes();
    }

}
