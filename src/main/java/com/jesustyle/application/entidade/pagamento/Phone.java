package com.jesustyle.application.entidade.pagamento;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class Phone {
    private String country_code;
    private String area_code;
    private String number;
}