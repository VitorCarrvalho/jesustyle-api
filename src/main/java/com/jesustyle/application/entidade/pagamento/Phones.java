package com.jesustyle.application.entidade.pagamento;

 
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class Phones {

    @JsonProperty("home_phone")
    private Phone home_phone;
}