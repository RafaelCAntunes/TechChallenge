package com.techChallenge.core.application.usecase.pedido;

import com.techChallenge.core.application.DTO.pedido.PedidoRequestDTO;
import com.techChallenge.core.application.repository.PedidoRepository;
import com.techChallenge.core.domain.entity.PedidoEntity;
import com.techChallenge.core.domain.enums.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoEntity executar(PedidoRequestDTO dto) {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setStatus(StatusPedido.RECEBIDO.toString());
        pedido.setItens(dto.toItensEntity());
        pedido.setClienteId(dto.getClienteId());
        return pedidoRepository.save(pedido);
    }
}