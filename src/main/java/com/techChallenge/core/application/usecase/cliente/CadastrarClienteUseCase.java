package com.techChallenge.core.application.usecase.cliente;

import com.techChallenge.core.domain.entity.ClienteEntity;
import com.techChallenge.core.application.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarClienteUseCase {

    @Autowired
    public  ClienteRepository clienteRepository;


    public ClienteEntity executar(String nome, String email) {

        if(nome == null && email == null)
            nome = "Anônimo";

        ClienteEntity cliente = new ClienteEntity(nome, email);


        return clienteRepository.save(cliente);
    }
}