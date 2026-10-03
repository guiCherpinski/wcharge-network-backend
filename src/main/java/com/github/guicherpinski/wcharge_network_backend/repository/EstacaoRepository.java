package com.github.guicherpinski.wcharge_network_backend.repository;

import com.github.guicherpinski.wcharge_network_backend.entity.EstacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstacaoRepository extends JpaRepository<EstacaoEntity, Long> {

    Optional<EstacaoEntity> findByNome(String nome);
}
