package com.jesustyle.application.entidade.pagamento;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDTO {

    public String id;
    public String code;
    public List<Items> items;
    public Phone phone;
    public Phones phones;
    public Customer customer;
    public BillingAddress billingAddress;
    public Card card;
    public CreditCard creditCard;
    @JsonProperty("payments")
    public List<Payments> payments;
    public OrderRequest orderRequest;
    @JsonProperty("referencia")
    public String referencia;

}
