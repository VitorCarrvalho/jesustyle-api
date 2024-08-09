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
public class Items {
    private String id;
    private String type;
    private String description;
    private int amount;
    private int quantity;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String code;

}
