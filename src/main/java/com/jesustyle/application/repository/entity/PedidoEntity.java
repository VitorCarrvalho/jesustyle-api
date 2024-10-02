package com.jesustyle.application.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.Customer;
import com.jesustyle.application.entidade.pagamento.Items;
import com.jesustyle.application.entidade.pagarme.Charge;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "pedido_entity")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String code;
    private int amount;
    private String currency;
    private boolean closed;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Items> items;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime closedAt;

    @OneToMany(mappedBy = "id") // Ensure this matches the property in Charge
    private List<Charge> charges;

}
