package com.jesustyle.application.entidade.pagamento;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Items")
public class Items {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido idPedido;
    private String type;
    private String description;
    private int amount;
    private int quantity;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String code;

}
