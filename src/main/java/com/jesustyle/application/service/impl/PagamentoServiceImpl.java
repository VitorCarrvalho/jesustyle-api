package com.jesustyle.application.service.impl;


import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.service.PagamentoService;
import com.jesustyle.application.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Slf4j
@Service
public class PagamentoServiceImpl implements PagamentoService {


    private static final String PAGARME_API_URL = "https://api.pagar.me/core/v5/orders";
    private static final String AUTHORIZATION_KEY = "sk_test_4e27008e14c24164bad6e7fdbfdd9dee";
    private static final String AUTHORIZATION_KEY_BASE_64 = "c2tfdGVzdF80ZTI3MDA4ZTE0YzI0MTY0YmFkNmU3ZmRiZmRkOWRlZTo=";

    @Override
    public Object criarPedido(Pedido pedido) throws IOException, InterruptedException {

        String pedidoString = convertOrderRequestToJson(pedido);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.pagar.me/core/v5/orders"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("authorization", "Basic c2tfdGVzdF80ZTI3MDA4ZTE0YzI0MTY0YmFkNmU3ZmRiZmRkOWRlZTo=")
                .method("POST", HttpRequest.BodyPublishers.ofString(pedidoString))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var pedidoCriado = response.body();
        log.info("Pedido criado com sucesso: " + pedidoCriado);

        return pedidoCriado;
    }

    @Override
    public Order consultaPedido(String idOrder) {
        return null;
    }

    @Override
    public String cancelarPedido(String idPedido) {
        return null;
    }

    private String convertOrderRequestToJson(Pedido orderRequest) {
        return JsonUtil.toJson(orderRequest);
    }
}
