package com.github.guicherpinski.wcharge_network_backend.entity;

import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.StatusCarregadorEnum;
import com.github.guicherpinski.wcharge_network_backend.entity.enumereted.TipoConectorEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_carregador")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarregadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estacao_id")
    private EstacaoEntity estacao;

    @Column(
            name = "codigo",
            nullable = false,
            unique = true,
            length = 50
    )
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "tipo_conector",
            nullable = false,
            length = 30
    )
    private TipoConectorEnum tipoConector;

    @Column(
            name = "potencia_kw",
            nullable = false
    )
    private BigDecimal potenciaKw;

    @Column(
            name = "valor_kwh",
            nullable = false
    )
    private BigDecimal valorKwh;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false,
            length = 30
    )
    private StatusCarregadorEnum status;
}
