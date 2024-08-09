package com.jesustyle.application.entidade.transporte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeSimulacao {
    private float peso;
    private float altura;
    private float largura;
    private float comprimento;
    private String tipo = "C"; // Padrão 'C'
    private float valor;
    private int quantidade;
}
