package com.jesustyle.application.entidade.pagamento;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    private String id;
    private String number;
    private String holder_name;
    private int exp_month;
    private int exp_year;
    private String cvv;
    private String first_six_digits;
    private String last_four_digits;
    private String brand;
    private String status;
    private String type;
    private String created_at;
    private String updated_at;
    private BillingAddress billing_address;
}
