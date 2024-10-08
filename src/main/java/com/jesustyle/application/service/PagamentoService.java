package com.jesustyle.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.entidade.pagarme.Order;

import java.io.IOException;
import java.util.List;

public interface PagamentoService {

    Order create(Pedido pedido, String idCliente) throws IOException, InterruptedException;

    Order get(long idOrder);

    List<Order> getPedidosByCliente(String idCliente) throws JsonProcessingException;

    List<Order> list(List<Long> ids);

    String cancel(String idPedido);
}
