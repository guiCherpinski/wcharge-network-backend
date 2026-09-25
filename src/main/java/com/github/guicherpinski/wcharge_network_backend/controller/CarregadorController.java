package com.github.guicherpinski.wcharge_network_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carregadores")
public class CarregadorController {

    private final CarregadorService service;

    public CarregadorController(CarregadorService service){
        this.service = service;
    }

}
