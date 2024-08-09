package com.jesustyle.application.entidade.pagarme;


 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class antifraud_response {

    private String status;
    private String score;
    private String provider_name;

}
