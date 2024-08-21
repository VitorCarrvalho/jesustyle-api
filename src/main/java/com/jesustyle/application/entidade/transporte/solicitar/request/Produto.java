package com.jesustyle.application.entidade.transporte.solicitar.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private double peso;
    private double altura;
    private double largura;
    private double comprimento;
    private String produto;
    private double valor;
    private int quantidade;
}
