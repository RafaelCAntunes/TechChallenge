package com.techChallenge.core.application.usecase.pedido;

import com.techChallenge.core.application.repository.PedidoRepository;
import com.techChallenge.core.domain.entity.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarPedidoPorIdUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoEntity executar(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}