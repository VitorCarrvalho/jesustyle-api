package com.jesustyle.application.entidade.pagarme;


 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class antifraud_response {

    private String status;
    private String score;
    private String provider_name;

}
