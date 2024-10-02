package com.jesustyle.application.entidade.pagarme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.Customer;
import com.jesustyle.application.repository.entity.PedidoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String gateway_id;
    private int amount;
    private int paid_amount;
    private String status;
    private String currency;
    private String payment_method;
    private String paid_at;
    private String created_at;
    private String updated_at;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private last_transaction lastTransaction; // Correct class name

    @ManyToOne // Add this to link back to PedidoEntity
    private PedidoEntity pedidoEntity; // Ensure this matches the reference in PedidoEntity

    @Embedded // Assuming gateway_response is not an entity
    private gateway_response gateway_response; // Ensure this matches the refer


    @Embedded // Assuming antifraud_response is not an entity
    private AntifraudResponse antifraud_response; // Ensure this matches the refer


}




