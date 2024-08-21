package com.jesustyle.application.entidade.transporte.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Simulacao {
    private String cepOrigem;
    private String cepDestino;
    private float vlrMerc;
    private float pesoMerc;
    @JsonProperty("volumes")
    private List<VolumeSimulacao> volumes;
    @JsonProperty("produtos")
    private List<ProdutoSimulacao> produtos;
    private List<String> servicos;
    private String ordernar;
}

