package com.jesustyle.application.entidade.pagamento;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class BillingAddress {
    private String line_1;
    private String zip_code;
    private String city;
    private String state;
    private String country;
}