package com.jesustyle.application.entidade.pagarme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable // Ensure this annotation is here
public class AntifraudResponse { // Use uppercase 'A'

    private String status;
    private String score;
    private String providerName; // Use camelCase for fields
}
