package com.jesustyle.application.entidade.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagarme.LastTransaction;
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
    private long id;

    @JoinColumn(name = "id")
    private LastTransaction lastTransaction;

    private int installments; // Número de parcelas
    private String statementDescriptor; // Descrição do estabelecimento

    @OneToOne
    @OneToMany(mappedBy = "credit_cards")
    private Card card; // Classe Card embutida

    // Relacionamento com BillingAddress, se necessário
}
