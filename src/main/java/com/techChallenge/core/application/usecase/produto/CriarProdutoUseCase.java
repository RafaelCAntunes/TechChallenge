package com.techChallenge.core.application.usecase.produto;

import com.techChallenge.core.application.repository.ProdutoRepository;
import com.techChallenge.core.domain.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoEntity executar(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }
}
