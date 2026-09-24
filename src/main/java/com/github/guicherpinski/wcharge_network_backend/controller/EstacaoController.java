package com.github.guicherpinski.wcharge_network_backend.controller;

import com.github.guicherpinski.wcharge_network_backend.dto.response.EstacaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/v1/estacoes")
public class EstacaoController {

    @GetMapping
    public ResponseEntity<List<EstacaoResponseDTO>> listarEstacoes(){

    }
}
