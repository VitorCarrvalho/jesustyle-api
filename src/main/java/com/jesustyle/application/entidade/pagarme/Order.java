package com.jesustyle.application.entidade.pagarme;

 
import com.jesustyle.application.entidade.pagamento.Customer;
import com.jesustyle.application.entidade.pagamento.Items;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class Order {
    private String id;
    private String code;
    private int amount;
    private String currency;
    private boolean closed;
    private List<Items> items;
    private Customer customer;
    private String status;
    private String created_at;
    private String updated_at;
    private String closed_at;
    private List<Charge> charges;
    private List<Object> checkouts;
}
