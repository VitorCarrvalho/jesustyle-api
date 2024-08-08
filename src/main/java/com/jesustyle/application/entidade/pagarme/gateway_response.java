package com.jesustyle.application.entidade.pagarme;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
 
public class gateway_response {

    public String code;
    public List<Object> errors;
}
