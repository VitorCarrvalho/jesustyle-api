package com.jesustyle.application.service;

import com.jesustyle.application.entidade.transporte.Simulacao;
import com.jesustyle.application.entidade.transporte.SimulacaoResp;

public interface TransporteService {

    String simular(Simulacao simulacao);

    String solicitar(Simulacao simulacao);

    String rastrear(Simulacao simulacao);
}
