package com.jesustyle.application.entidade.pagarme;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jesustyle.application.entidade.pagamento.Customer;
import com.jesustyle.application.entidade.pagamento.Items;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private String id;
    private String code;
    private int amount;
    private String currency;
    private boolean closed;
    private List<Items> items;
    private Customer customer;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String closed_at;

    @JsonProperty("charges")
    private List<Charge> charges;
    private List<Object> checkouts;
}
