package com.techChallenge.adapters.driver.API;

import com.techChallenge.core.application.DTO.produto.ProdutoRequestDTO;
import com.techChallenge.core.application.DTO.produto.ProdutoResponseDTO;
import com.techChallenge.core.application.usecase.produto.*;
import com.techChallenge.core.domain.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
public class ProdutoController {

    @Autowired
    private CriarProdutoUseCase criarProdutoUseCase;

    @Autowired
    private ListarProdutosUseCase listarProdutosUseCase;

    @Autowired
    private BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @Autowired
    private BuscarProdutosPorCategoriaUseCase buscarProdutosPorCategoriaUseCase;

    @Autowired
    private AtualizarProdutoUseCase atualizarProdutoUseCase;

    @Autowired
    private RemoverProdutoUseCase removerProdutoUseCase;

    @Operation(summary = "Criar produto")
    @ApiResponse(responseCode = "200", description = "Produto criado com sucesso")
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@RequestBody ProdutoRequestDTO dto) {
        ProdutoEntity produto = criarProdutoUseCase.executar(dto.toDomain());
        return ResponseEntity.ok(new ProdutoResponseDTO(produto));
    }

    @Operation(summary = "Listar todos os produtos")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        List<ProdutoEntity> produtos = listarProdutosUseCase.executar();
        List<ProdutoResponseDTO> response = produtos.stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Buscar produto por ID")
    @ApiResponse(responseCode = "200", description = "Produto encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        ProdutoEntity produto = buscarProdutoPorIdUseCase.executar(id);
        return ResponseEntity.ok(new ProdutoResponseDTO(produto));
    }

    @Operation(summary = "Buscar produtos por categoria")
    @ApiResponse(responseCode = "200", description = "Produtos encontrados por categoria")
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarPorCategoria(@PathVariable String categoria) {
        List<ProdutoEntity> produtos = buscarProdutosPorCategoriaUseCase.executar(categoria);
        List<ProdutoResponseDTO> response = produtos.stream()
                .map(ProdutoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualizar produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto) {
        ProdutoEntity produtoAtualizado = atualizarProdutoUseCase.executar(id, dto.toDomain());
        return ResponseEntity.ok(new ProdutoResponseDTO(produtoAtualizado));
    }

    @Operation(summary = "Remover produto")
    @ApiResponse(responseCode = "204", description = "Produto removido com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        removerProdutoUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}
