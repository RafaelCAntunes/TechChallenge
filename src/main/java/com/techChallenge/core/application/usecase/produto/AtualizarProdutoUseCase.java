package com.techChallenge.core.application.usecase.produto;

import com.techChallenge.core.application.repository.ProdutoRepository;
import com.techChallenge.core.domain.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoEntity executar(Long id, ProdutoEntity novoProduto) {
        ProdutoEntity produtoAtual = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoAtual.setNomeProduto(novoProduto.getNomeProduto());
        produtoAtual.setDescricao(novoProduto.getDescricao());
        produtoAtual.setPrecoUnitario(novoProduto.getPrecoUnitario());
        produtoAtual.setCategoria(novoProduto.getCategoria());

        return produtoRepository.save(produtoAtual);
    }
}
