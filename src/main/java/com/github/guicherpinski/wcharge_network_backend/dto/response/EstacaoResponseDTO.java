package com.github.guicherpinski.wcharge_network_backend.dto.response;

public record EstacaoResponseDTO(
        Long id,
        String nome,
        String cidade,
        String endereco,
        String status
) {
}
