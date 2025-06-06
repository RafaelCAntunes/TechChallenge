package com.techChallenge.core.application.usecase.produto;

import com.techChallenge.core.application.repository.ProdutoRepository;
import com.techChallenge.core.domain.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarProdutosPorCategoriaUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoEntity> executar(String categoria) {
        return produtoRepository.findByCategoriaIgnoreCase(categoria);
    }
}
