package com.jesustyle.application.entidade.pagamento;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jesustyle.application.repository.entity.PedidoEntity;
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
@Table(name = "custumer")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String email;
    private String document;
    private String type;
    private String delinquent;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "custumer", nullable = false)
    private Phones phones;
}