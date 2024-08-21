package com.jesustyle.application.entidade.transporte.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulacaoResponse {
    private Double vlrFrete;
    private Integer prazoEnt;
    private Integer prazoEntMin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dtPrevEnt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dtPrevEntMin;

    private List<Tarifa> tarifas;
    private Error error;
    private Long idSimulacao;
    private Long idTransp;
    private String cnpjTransp;
    private Long idTranspResp;
    private String cnpjTranspResp;
    private List<String> alertas;
    private String nfObrig;
    private String urlLogo;
    private String transpNome;
    private String descricao;
    private String servico;
    private String referencia;
}

