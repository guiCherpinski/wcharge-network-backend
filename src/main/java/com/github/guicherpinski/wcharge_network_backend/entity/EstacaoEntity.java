package com.github.guicherpinski.wcharge_network_backend.entity;

import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_estacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "nome",
            nullable = false,
            length = 150
    )
    private String nome;

    @Column(
            name = "cidade",
            nullable = false,
            length = 100
    )
    private String cidade;

    @Column(
            name = "endereco",
            nullable = false,
            length = 255
    )
    private String endereco;

    @Column(
            name = "status",
            nullable = false,
            length = 30
    )
    private StatusEnum status;
}
