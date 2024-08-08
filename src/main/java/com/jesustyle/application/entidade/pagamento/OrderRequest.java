package com.jesustyle.application.entidade.pagamento;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class OrderRequest {
    private List<Items> items;
    private Customer customer;
    private List<Payments> payments;
}