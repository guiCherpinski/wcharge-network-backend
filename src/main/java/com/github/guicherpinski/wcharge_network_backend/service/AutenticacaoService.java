package com.github.guicherpinski.wcharge_network_backend.service;

import com.github.guicherpinski.wcharge_network_backend.exception.UsuarioNotFound;
import com.github.guicherpinski.wcharge_network_backend.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsuarioNotFound("erro - usuário não encontrado"));
    }
}
