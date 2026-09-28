package com.github.guicherpinski.wcharge_network_backend.security;

import com.github.guicherpinski.wcharge_network_backend.repository.UsuarioRepository;
import com.github.guicherpinski.wcharge_network_backend.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.PasswordAuthentication;

@Configuration
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService service;
    private final UsuarioRepository repository;

    public SecurityFilter(TokenService service, UsuarioRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);

        if (token != null){
            String subject = service.getSubject(token);

            if (subject != null){
                var usuario = repository.findByUsername(subject).orElse(null);

                if (usuario != null){
                    var autenticacao = new UsernamePasswordAuthenticationToken(
                            usuario,null,usuario.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(autenticacao);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request){
        String autorizationHeader = request.getHeader("Authorization");
        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")){
            return autorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}
