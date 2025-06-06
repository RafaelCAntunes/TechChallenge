package com.techChallenge.core.application.DTO.cliente;

import com.techChallenge.core.domain.entity.ClienteEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Dados para cadastrar um cliente")
public class ClienteRequestDTO {

    @Schema(description = "Nome completo", example = "João da Silva")
    private String nome;

    @Schema(description = "E-mail do cliente", example = "joao@email.com")
    private String email;

    @Schema(description = "CPF do cliente (usado apenas na gestao de cliente)", example = "12345678900")
    private String cpf;

    public ClienteRequestDTO(ClienteEntity cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();

    }
}
