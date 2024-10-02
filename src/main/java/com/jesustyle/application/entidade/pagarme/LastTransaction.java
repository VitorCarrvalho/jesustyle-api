package com.jesustyle.application.entidade.pagarme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "last_transaction")
public class LastTransaction { // Mudança para CamelCase

    @Id
    private String id;

    @Column(name = "transaction_type")
    private String transactionType; // Use camelCase

    @Column(name = "gateway_id")
    private String gatewayId; // Use camelCase

    private int amount;
    private String status;
    private boolean success;
    private int installments;

    @Column(name = "statement_descriptor")
    private String statementDescriptor; // Use camelCase

    @Column(name = "acquirer_name")
    private String acquirerName; // Use camelCase

    @Column(name = "acquirer_tid")
    private String acquirerTid; // Use camelCase

    @Column(name = "acquirer_nsu")
    private String acquirerNsu; // Use camelCase

    @Column(name = "acquirer_auth_code")
    private String acquirerAuthCode; // Use camelCase

    @Column(name = "acquirer_message")
    private String acquirerMessage; // Use camelCase

    @Column(name = "acquirer_return_code")
    private String acquirerReturnCode; // Use camelCase

    @Column(name = "operation_type")
    private String operationType; // Use camelCase

    @OneToOne // Ou outra anotação apropriada, dependendo da relação
    private Card card;

    @Column(name = "funding_source")
    private String fundingSource; // Use camelCase

    @Column(name = "created_at")
    private LocalDateTime createdAt; // Use camelCase

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Use camelCase

    @Embedded // Corrigido para Embedded
    private GatewayResponse gatewayResponse; // Use CamelCase

    @Embedded // Corrigido para Embedded
    private AntifraudResponse antifraudResponse; // Use CamelCase

    private Object metadata;
}
