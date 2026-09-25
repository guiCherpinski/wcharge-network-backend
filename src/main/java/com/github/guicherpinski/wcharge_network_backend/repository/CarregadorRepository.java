package com.github.guicherpinski.wcharge_network_backend.repository;

import com.github.guicherpinski.wcharge_network_backend.entity.CarregadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarregadorRepository extends JpaRepository<CarregadorEntity, Long> {
}
