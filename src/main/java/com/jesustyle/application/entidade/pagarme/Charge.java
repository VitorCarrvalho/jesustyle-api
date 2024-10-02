package com.jesustyle.application.entidade.pagarme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.Customer;
import com.jesustyle.application.repository.entity.PedidoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private PedidoEntity pedido;

    private String code;

    @Column(name = "gateway_id")
    private String gatewayId; // Alterado para camelCase

    private int amount;
    private int paidAmount; // Alterado para camelCase
    private String status;
    private String currency;

    @Column(name = "payment_method")
    private String paymentMethod; // Alterado para camelCase

    @Column(name = "paid_at")
    private String paidAt; // Alterado para camelCase

    @Column(name = "created_at")
    private String createdAt; // Alterado para camelCase

    @Column(name = "updated_at")
    private String updatedAt; // Alterado para camelCase

    @ManyToOne
    private LastTransaction lastTransaction;


    @Embedded
    private GatewayResponse gatewayResponse;

    @Embedded
    private AntifraudResponse antifraudResponse;
}
