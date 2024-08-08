package com.jesustyle.application.entidade.transporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Simulacao {
    private String cepOrigem;
    private String cepDestino;
    private float vlrMerc;
    private float pesoMerc;
    private List<VolumeSimulacao> volumes;
    private List<ProdutoSimulacao> produtos;
    private List<String> servicos;
    private String ordernar;
}

