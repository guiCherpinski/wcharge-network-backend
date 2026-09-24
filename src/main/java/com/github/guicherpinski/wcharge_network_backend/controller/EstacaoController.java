package com.github.guicherpinski.wcharge_network_backend.controller;

import com.github.guicherpinski.wcharge_network_backend.dto.response.EstacaoResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.service.EstacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/v1/estacoes")
public class EstacaoController {

    private final EstacaoService service;

    public EstacaoController(EstacaoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstacaoResponseDTO>> listarEstacoes(){
        return ResponseEntity.ok(service.listarEstacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacaoResponseDTO> buscarEndereco(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarEstacao(id));
    }
}
