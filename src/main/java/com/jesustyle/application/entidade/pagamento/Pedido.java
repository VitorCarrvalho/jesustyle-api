//package com.jesustyle.application.entidade.pagamento;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Table(name = "PedidoEntity")
//public class Pedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//
//    private String code;
//
//    @OneToMany(mappedBy = "pedido")
//    private List<Items> items;
//
//    private Phone phone;
//    private Phones phones;
//    private Customer customer;
//    private BillingAddress billingAddress;
//
//    @JsonProperty("payments")
//    @OneToOne(mappedBy = "pedido")
//    private List<Payments> payments;
//
//}