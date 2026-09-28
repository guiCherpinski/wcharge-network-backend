package com.github.guicherpinski.wcharge_network_backend.controller;

import com.github.guicherpinski.wcharge_network_backend.dto.request.DadosAutenticacaoRequestDTO;
import com.github.guicherpinski.wcharge_network_backend.dto.response.TokenResponseDTO;
import com.github.guicherpinski.wcharge_network_backend.entity.UsuarioEntity;
import com.github.guicherpinski.wcharge_network_backend.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService service;

    public AutenticacaoController(AuthenticationManager manager, TokenService service){
        this.manager = manager;
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> efetuarLogin(@RequestBody @Valid DadosAutenticacaoRequestDTO request){
        var tokenAutenticacao = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        var autenticacao = manager.authenticate(tokenAutenticacao);

        String token = service.gerarToken((UsuarioEntity)  autenticacao.getPrincipal());

        return  ResponseEntity.ok(new TokenResponseDTO(token));
    }

}
