package com.jesustyle.application.entidade.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.repository.entity.PedidoEntity; // Correct reference
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "items")
public class Items {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoEntity pedido; // Correct reference to PedidoEntity

    private String type;
    private String description;
    private int amount;
    private int quantity;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String code;
}
