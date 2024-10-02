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
    private Customer customer;

    @ManyToOne
    private LastTransaction lastTransaction; // Nome correto da classe

    @ManyToOne // Adicione isso para vincular de volta ao PedidoEntity
    private PedidoEntity pedidoEntity; // Verifique se isso corresponde à referência em PedidoEntity

    @Embedded // Presumindo que gateway_response não é uma entidade
    private GatewayResponse gatewayResponse; // Alterado para camelCase

    @Embedded // Presumindo que antifraud_response não é uma entidade
    private AntifraudResponse antifraudResponse; // Alterado para camelCase
}
