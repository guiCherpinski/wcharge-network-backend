package com.github.guicherpinski.wcharge_network_backend.mapper;

import com.github.guicherpinski.wcharge_network_backend.dto.request.EstacaoRequestDTO;
import com.github.guicherpinski.wcharge_network_backend.dto.response.EstacaoResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.entity.EstacaoEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class EstacaoMapper {

    public EstacaoEntity toEntity(EstacaoRequestDTO request){
        return EstacaoEntity.builder()
                .nome(request.nome())
                .cidade(request.cidade())
                .endereco(request.endereco())
                .build();
    }

    public EstacaoResponseDTO toResponse(EstacaoEntity entity){
        return new EstacaoResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCidade(),
                entity.getEndereco(),
                entity.getStatus()
        );
    }

    public List<EstacaoResponseDTO> toResponseList(List<EstacaoEntity> entitys){
        return entitys.stream().map(this::toResponse).toList();
    }
}
