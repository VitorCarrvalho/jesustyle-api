package com.jesustyle.application.entidade.pagamento;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {
    private int installments; //número de parcelas
    private String statement_descriptor; //descrição do estabelecimento
    private Card card;
}