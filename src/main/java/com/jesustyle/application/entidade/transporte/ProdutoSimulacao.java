package com.jesustyle.application.entidade.transporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSimulacao {
    private float peso;
    private float altura;
    private float largura;
    private float comprimento;
    private float valor;
    private int quantidade;
}
