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
@Entity
@Table(name = "Card")
public class Card {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private CreditCard creditCard;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id") // ou o nome da coluna que você deseja
    private BillingAddress billingAddress;

}
