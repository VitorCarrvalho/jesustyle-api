package com.jesustyle.application.entidade.transporte.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {
    private Double valor;
    private String descricao;
    private String faixa;
}
