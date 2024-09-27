package com.jesustyle.application.entidade.pagamento;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phones {
    private Phone homePhone; // Make sure Phone is also properly defined
}
