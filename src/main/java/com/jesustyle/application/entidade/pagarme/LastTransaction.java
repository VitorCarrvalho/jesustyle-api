package com.jesustyle.application.entidade.pagarme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.CreditCard;
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
public class LastTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "gateway_id")
    private String gatewayId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status;

    @Column(name = "success")
    private boolean success;

    @Column(name = "installments")
    private int installments;

    @Column(name = "statement_descriptor")
    private String statementDescriptor;

    @Column(name = "acquirer_name")
    private String acquirerName;

    @Column(name = "acquirer_tid")
    private String acquirerTid;

    @Column(name = "acquirer_nsu")
    private String acquirerNsu;

    @Column(name = "acquirer_auth_code")
    private String acquirerAuthCode;

    @Column(name = "acquirer_message")
    private String acquirerMessage;

    @Column(name = "acquirer_return_code")
    private String acquirerReturnCode;

    @Column(name = "operation_type")
    private String operationType;

    @JoinColumn(name = "last_transaction")
    private CreditCard creditCard;

    @Column(name = "funding_source")
    private String fundingSource;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

//    @Embedded // Corrigido para Embedded
//    private GatewayResponse gatewayResponse;

//    @Embedded // Corrigido para Embedded
//    private AntifraudResponse antifraudResponse;

    @Column(name = "metadata")
    private Object metadata;
}
