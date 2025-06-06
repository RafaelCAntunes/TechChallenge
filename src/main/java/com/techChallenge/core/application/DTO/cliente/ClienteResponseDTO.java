package com.techChallenge.core.application.DTO.cliente;

import com.techChallenge.core.domain.entity.ClienteEntity;
import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    public ClienteResponseDTO(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
    }
}