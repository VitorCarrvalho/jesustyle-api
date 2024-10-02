package com.jesustyle.application.entidade.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int installments; // Número de parcelas
    private String statementDescriptor; // Descrição do estabelecimento

    @Embedded
    private Card card; // Classe Card embutida

    // Relacionamento com BillingAddress, se necessário
}
