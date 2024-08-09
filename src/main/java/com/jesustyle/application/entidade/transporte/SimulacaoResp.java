package com.jesustyle.application.entidade.transporte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class SimulacaoResp {
    private float vlrFrete;
    private int prazoEnt;
    private int prazoEntMin;
    private String dtPrevEnt;
    private String dtPrevEntMin;
    private List<Tarifas> tarifas;
    private ErrorResult error;
    private int idSimulacao;
    private int idTransp;
    private String cnpjTransp;
    private int idTranspResp;
    private String cnpjTranspResp;
    private List<String> alertas;
    private String nf_obrig;
    private String url_logo;
    private String transp_nome;
    private String descricao;
    private String servico;
    private String referencia;
}
