package com.jesustyle.application.entidade.transporte.solicitar.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransporteRequest {
    private boolean gerarPdf;
    private String formatoPdf;
    private Pedido pedido;
    private Remetente remetente;
    private Destinatario destinatario;
    private List<Volume> volumes;
    private List<Produto> produtos;
    private String pontoPostagem;
    private String pontoEntrega;
    private String transportadora;
    private String referencia;
    private boolean usarTransportadoraContrato;
    private List<String> servicos;
}

