package com.github.guicherpinski.wcharge_network_backend.service;

import com.github.guicherpinski.wcharge_network_backend.dto.response.EstacaoResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.entity.EstacaoEntity;
import com.github.guicherpinski.wcharge_network_backend.exception.EmptyListException;
import com.github.guicherpinski.wcharge_network_backend.exception.EstacaoNotFound;
import com.github.guicherpinski.wcharge_network_backend.mapper.EstacaoMapper;
import com.github.guicherpinski.wcharge_network_backend.repository.EstacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EstacaoService {

    private final EstacaoRepository repository;
    private final EstacaoMapper mapper;

    public EstacaoService(EstacaoRepository repository, EstacaoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public List<EstacaoResponseDTO> listarEstacoes(){
        if (repository.findAll().isEmpty()){
            throw new EmptyListException("erro - nenhuma estação encontrada");
        }

        List<EstacaoEntity> estacoes = repository.findAll();
        List<EstacaoResponseDTO> responses = mapper.toResponseList(estacoes);

        return responses;
    }

    @Transactional
    public EstacaoResponseDTO buscarEstacao(Long id){
        EstacaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new EstacaoNotFound("erro - estação não encontrada"));
        EstacaoResponseDTO response = mapper.toResponse(entity);

        return response;
    }
}
