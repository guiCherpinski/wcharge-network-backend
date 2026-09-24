package com.github.guicherpinski.wcharge_network_backend.dto.response;

import com.github.guicherpinski.wcharge_network_backend.entity.EstacaoEntity;
import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.StatusCarregadorEnum;
import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.TipoConectorEnum;

import java.math.BigDecimal;

public record CarregadorResponseDTO(
        Long id,
        EstacaoEntity estacao,
        String codigo,
        TipoConectorEnum tipoConector,
        BigDecimal potenciaKw,
        BigDecimal valorKwh,
        StatusCarregadorEnum statusCarregador
) {
}
