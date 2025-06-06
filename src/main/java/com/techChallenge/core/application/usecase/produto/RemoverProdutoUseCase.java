package com.techChallenge.core.application.usecase.produto;

import com.techChallenge.core.application.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void executar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
