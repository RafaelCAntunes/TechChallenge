package com.techChallenge.core.application.usecase.pedido;

import com.techChallenge.core.application.repository.PedidoRepository;
import com.techChallenge.core.domain.entity.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarStatusPedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoEntity executar(Long id, String status) {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        ; // este método deve alterar o status sequencialmente

        pedido.setStatus(status);

        return pedidoRepository.save(pedido);
    }
}
