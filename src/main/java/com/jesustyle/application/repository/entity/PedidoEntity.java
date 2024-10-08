package com.jesustyle.application.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "id_pedido")
    private String idPedido;
    @Column(name = "body")
    private String body;
}
