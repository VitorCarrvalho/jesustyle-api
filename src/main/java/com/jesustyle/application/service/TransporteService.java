package com.jesustyle.application.service;

import com.jesustyle.application.entidade.pagamento.PedidoDTO;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.request.Simulacao;
import com.jesustyle.application.entidade.transporte.response.SimulacaoResponse;

public interface TransporteService {

    SimulacaoResponse simular(Simulacao simulacao);

    String solicitar(Order ordemPedido, String referencia, PedidoDTO pedidoDto);

    String rastrear(Simulacao simulacao);

    String imprimirEtiqueta(String codRastreio);
}
