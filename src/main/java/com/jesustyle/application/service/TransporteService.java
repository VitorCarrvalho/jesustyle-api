package com.jesustyle.application.service;

import com.jesustyle.application.entidade.pagamento.PedidoDTO;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.request.Simulacao;
import com.jesustyle.application.entidade.transporte.response.SimulacaoResponse;
import com.jesustyle.application.repository.entity.PedidoEntity;

public interface TransporteService {

    SimulacaoResponse simular(Simulacao simulacao);

    String solicitar(PedidoEntity ordemPedido, String referencia, PedidoDTO pedidoDto);

    String rastrear(Simulacao simulacao);

    String buscaRastreio(String codRastreio);
}
