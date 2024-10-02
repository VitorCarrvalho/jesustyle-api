package com.jesustyle.application.service;

import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.solicitar.request.Pedido;
import com.jesustyle.application.repository.entity.PedidoEntity;

import java.io.IOException;

public interface PagamentoService {

    PedidoEntity criarPedido(Pedido pedido) throws IOException, InterruptedException;

    Order consultaPedido(String idOrder);

    String cancelarPedido(String idPedido);
}
