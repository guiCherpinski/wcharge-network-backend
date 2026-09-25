package com.github.guicherpinski.wcharge_network_backend.service;

import com.github.guicherpinski.wcharge_network_backend.dto.response.CarregadorResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.entity.CarregadorEntity;
import com.github.guicherpinski.wcharge_network_backend.exception.CarregadorNotFound;
import com.github.guicherpinski.wcharge_network_backend.exception.EmptyListException;
import com.github.guicherpinski.wcharge_network_backend.mapper.CarregadorMapper;
import com.github.guicherpinski.wcharge_network_backend.repository.CarregadorRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarregadorService {

    private final CarregadorRepository repository;
    private final CarregadorMapper mapper;

    public CarregadorService(CarregadorRepository repository, CarregadorMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CarregadorResponseDTO> listarCarregadores(){
        if (repository.findAll().isEmpty()){
            throw new EmptyListException("erro - nenhum carregador foi encontrado");
        }

        List<CarregadorEntity> entitys = repository.findAll();
        List<CarregadorResponseDTO> responses = mapper.toResponseList(entitys);

        return responses;
    }

    public CarregadorResponseDTO buscarCarregador(Long id){
        CarregadorEntity entity = repository.findById(id)
                .orElseThrow(() -> new CarregadorNotFound("erro - carregador não encontrado"));

        CarregadorResponseDTO response = mapper.toResponse(entity);

        return response;
    }
}
