package com.jesustyle.application.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.entidade.pagamento.Customer;
import com.jesustyle.application.entidade.pagamento.Items;
import com.jesustyle.application.entidade.pagarme.Charge;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "PedidoEntity")
public class PedidoEntity {

    @Id
    private String id;
    private String code;
    private int amount;
    private String currency;
    private boolean closed;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Items> items;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Customer customer;
    private String status;
    private String created_at;
    private String updated_at;
    private String closed_at;

    private List<Charge> charges;
    private List<Object> checkouts;
}



