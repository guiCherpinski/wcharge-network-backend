package com.github.guicherpinski.wcharge_network_backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.guicherpinski.wcharge_network_backend.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.jwt.secret-key}")
    private String secret;

    private String gerarToken(UsuarioEntity entity){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("api de carregamento")
                    .withSubject(entity.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        }catch(JWTCreationException e){
            throw new RuntimeException("erro - não foi possivel gerar o token ",e);
        }
    }

    private String getSubject(String tokenJWT){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("api de carregamento")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }catch (JWTVerificationException e){
            return null;
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}
