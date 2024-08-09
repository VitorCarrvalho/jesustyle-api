package com.jesustyle.application.entidade.pagamento;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private String id;
    private String name;
    private String email;
    private String document;
    private String type;
    private String delinquent;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Phones phones;
}