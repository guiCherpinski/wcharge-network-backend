package com.github.guicherpinski.wcharge_network_backend.dto.response;

import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.StatusEnum;

public record EstacaoResponseDTO(
        Long id,
        String nome,
        String cidade,
        String endereco,
        StatusEnum status
) {
}
