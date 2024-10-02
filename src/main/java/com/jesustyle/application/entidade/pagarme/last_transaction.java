package com.jesustyle.application.entidade.pagarme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.Card;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity // Add this annotation
public class last_transaction { // Rename class to follow Java naming conventions

    @Id // Add this annotation for the identifier
    private String id;

    private String transaction_type;
    private String gateway_id;
    private int amount;
    private String status;
    private boolean success;
    private int installments;
    private String statement_descriptor;
    private String acquirer_name;
    private String acquirer_tid;
    private String acquirer_nsu;
    private String acquirer_auth_code;
    private String acquirer_message;
    private String acquirer_return_code;
    private String operation_type;
    private Card card;
    private String funding_source;
    private String created_at;
    private String updated_at;
    private gateway_response gateway_response; // Ensure proper casing
    private AntifraudResponse antifraud_response; // Ensure proper casing
    private Object metadata;
}
