package com.github.guicherpinski.wcharge_network_backend.mapper;

import com.github.guicherpinski.wcharge_network_backend.dto.request.CarregadorRequestDTO;
import com.github.guicherpinski.wcharge_network_backend.dto.response.CarregadorResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.dto.response.EstacaoResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.entity.CarregadorEntity;
import com.github.guicherpinski.wcharge_network_backend.entity.EstacaoEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CarregadorMapper {

    private final EstacaoMapper estacaoMapper;

    public CarregadorMapper(EstacaoMapper estacaoMapper){
        this.estacaoMapper = estacaoMapper;
    }

    public CarregadorEntity toEntity(CarregadorRequestDTO request, EstacaoEntity entity){
        return CarregadorEntity.builder()
                .estacao(entity)
                .codigo(request.codigo())
                .tipoConector(request.tipoConector())
                .potenciaKw(request.potenciaKw())
                .valorKwh(request.valorKwh())
                .status(request.statusCarregador())
                .build();
    }

    public CarregadorResponseDTO toResponse(CarregadorEntity entity){
        EstacaoResponseDTO response = estacaoMapper.toResponse(entity.getEstacao());

        return new CarregadorResponseDTO(
                entity.getId(),
                response,
                entity.getCodigo(),
                entity.getTipoConector(),
                entity.getPotenciaKw(),
                entity.getValorKwh(),
                entity.getStatus()
        );
    }

    public List<CarregadorResponseDTO> toResponseList(List<CarregadorEntity> entitys){
        return entitys.stream().map(this::toResponse).toList();
    }
}
