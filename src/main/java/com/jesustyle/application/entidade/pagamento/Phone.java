package com.jesustyle.application.entidade.pagamento;

import jakarta.persistence.Embeddable; // Use Entity if it's an entity
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable // Use @Entity if it's an entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    private String areaCode;
    private String number;
}
