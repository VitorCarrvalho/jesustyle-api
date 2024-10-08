package com.jesustyle.application.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.solicitar.request.Pedido;
import com.jesustyle.application.repository.PedidoRepository;
import com.jesustyle.application.repository.entity.PedidoEntity;
import com.jesustyle.application.service.PagamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;


@Slf4j
@Service
public class PagamentoServiceImpl implements PagamentoService {


    private static final String PAGARME_API_URL = "https://api.pagar.me/core/v5/orders";


    private static final String AUTHORIZATION_KEY = "sk_test_4e27008e14c24164bad6e7fdbfdd9dee";
    //PRD
    // private static final String AUTHORIZATION_KEY_BASE_64 = "c2tfdGVzdF80ZTI3MDA4ZTE0YzI0MTY0YmFkNmU3ZmRiZmRkOWRlZTo=";
    //DEV
    private static final String AUTHORIZATION_KEY_BASE_64 = "c2tfdGVzdF80ZTI3MDA4ZTE0YzI0MTY0YmFkNmU3ZmRiZmRkOWRlZTo=";

    @Autowired
    PedidoRepository pedidoRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    //1 nome : Tipo     2 Tipo de retorno      3 |Nome do método          3:1 (Pedido pedido) parâmetros
    public PedidoEntity criarPedido(Pedido pedido) throws IOException, InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        mapper.registerModule(new JavaTimeModule());

        String pedidoString = mapper.writeValueAsString(pedido);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.pagar.me/core/v5/orders"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("authorization", "Basic c2tfNTNiM2YzMzA2N2MyNDEwYmEwOWFiMWNmODA1OGE4MWY=")
                .method("POST", HttpRequest.BodyPublishers.ofString(pedidoString))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var pedidoCriado = response.body();
        log.info("Pedido criado com sucesso: " + pedidoCriado);


        var retornoPagarme = mapper.readValue(pedidoCriado, PedidoEntity.class);

        savePedido(retornoPagarme);
        return retornoPagarme;
    }
    private void savePedido(PedidoEntity retornoPagarme) {
        pedidoRepository.save(retornoPagarme);
    }

    @Override
    public Order consultaPedido(String idOrder) {
        return null;
    }

    @Override
    public String cancelarPedido(String idPedido) {
        return null;
    }
}
