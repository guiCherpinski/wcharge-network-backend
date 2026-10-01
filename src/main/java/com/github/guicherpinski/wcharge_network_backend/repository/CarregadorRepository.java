package com.github.guicherpinski.wcharge_network_backend.repository;

import com.github.guicherpinski.wcharge_network_backend.entity.CarregadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarregadorRepository extends JpaRepository<CarregadorEntity, Long> {

    Optional<CarregadorEntity> findByCodigo(String codigo);
}
