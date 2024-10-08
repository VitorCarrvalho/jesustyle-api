package com.jesustyle.application.entidade.pagarme;


 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jesustyle.application.entidade.pagamento.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge {
    private String id;
    private String code;
    private String gateway_id;
    private int amount;
    private int paid_amount;
    private String status;
    private String currency;
    private String payment_method;
    private String paid_at;
    private String created_at;
    private String updated_at;
    private Customer customer;
    @JsonProperty("last_transaction")
    private last_transaction lastTransaction;
}
