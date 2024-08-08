package com.jesustyle.application.entidade.pagamento;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class CreditCard {
    private int installments; //número de parcelas
    private String statement_descriptor; //descrição do estabelecimento
    private Card card;
}