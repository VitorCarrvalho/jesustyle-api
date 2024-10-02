package com.jesustyle.application.entidade.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Card {

    private String number;
    private String holderName;

    @JsonProperty("exp_month")
    private int expMonth;

    @JsonProperty("exp_year")
    private int expYear;

    private String cvv;

    @JsonProperty("first_six_digits")
    private String firstSixDigits;

    @JsonProperty("last_four_digits")
    private String lastFourDigits;

    private String brand;
    private String status;
    private String type;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    // Endereço de cobrança
    @Embedded
    private BillingAddress billingAddress;
}
