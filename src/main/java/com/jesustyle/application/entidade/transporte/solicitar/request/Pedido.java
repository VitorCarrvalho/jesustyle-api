package com.jesustyle.application.entidade.transporte.solicitar.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private String tipo;
    private String numero;
    private String serie;
    private String chave;
    private String chaveCTe;
    private String xml;
    private String numeroCli;
    private double vlrMerc;
    private double pesoMerc;
}
