package com.jesustyle.application.service;

import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.entidade.pagarme.Order;

import java.io.IOException;

public interface PagamentoService {

    Object criarPedido(Pedido pedido) throws IOException, InterruptedException;

    Order consultaPedido(String idOrder);

    String cancelarPedido(String idPedido);
}
