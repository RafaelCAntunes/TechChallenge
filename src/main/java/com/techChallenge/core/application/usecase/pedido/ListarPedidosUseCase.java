package com.techChallenge.core.application.usecase.pedido;

import com.techChallenge.core.application.repository.PedidoRepository;
import com.techChallenge.core.domain.entity.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPedidosUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoEntity> executar() {
        return pedidoRepository.findAll();
    }
}
