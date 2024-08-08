package com.jesustyle.application.entidade.transporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarifas {
    private float valor;
    private String descricao;
    private String faixa;
}
