package com.github.guicherpinski.wcharge_network_backend.controller;

import com.github.guicherpinski.wcharge_network_backend.dto.response.CarregadorResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.service.CarregadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/carregadores")
public class CarregadorController {

    private final CarregadorService service;

    public CarregadorController(CarregadorService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CarregadorResponseDTO>> listarCarregadores(){
        return ResponseEntity.ok(service.listarCarregadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarregadorResponseDTO> buscarCarregador(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarCarregador(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarregador(@PathVariable Long id){
        service.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

}
