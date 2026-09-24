package com.github.guicherpinski.wcharge_network_backend.dto.request;

import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.StatusCarregadorEnum;
import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.TipoConectorEnum;

import java.math.BigDecimal;

public record CarregadorRequestDTO(
        Long id,
        String codigo,
        TipoConectorEnum tipoConector,
        BigDecimal potenciaKw,
        BigDecimal valorKwh,
        StatusCarregadorEnum statusCarregador
) {
}
