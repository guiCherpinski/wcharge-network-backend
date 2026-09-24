package com.github.guicherpinski.wcharge_network_backend.entity;

import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.StatusSessaoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_sessao_recarga")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SessaoRecarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carregador_id")
    private CarregadorEntity carregador;

    @Column(
            name = "data_inicio",
            nullable = true
    )
    private LocalDateTime dataInicio;

    @Column(
            name = "data_fim"
    )
    private LocalDateTime dataFim;

    @Column(
            name = "kwh_consumido"
    )
    private BigDecimal kwhConsumido;

    @Column(
            name = "valor_total"
    )
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status_sessao",
            nullable = false,
            length = 30
    )
    private StatusSessaoEnum statusSessao;


}
