package com.jesustyle.application.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.repository.PagamentoRepository;
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
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;
    private static final String PAGARME_API_URL = "https://api.pagar.me/core/v5/orders";
    private static final String AUTHORIZATION_KEY = "sk_test_4e27008e14c24164bad6e7fdbfdd9dee";
    private static final String AUTHORIZATION_KEY_BASE_64 = "c2tfdGVzdF80ZTI3MDA4ZTE0YzI0MTY0YmFkNmU3ZmRiZmRkOWRlZTo=";

    @Override
    public Order create(Pedido pedido, String idCliente) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        mapper.registerModule(new JavaTimeModule());

        String pedidoString = mapper.writeValueAsString(pedido);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.pagar.me/core/v5/orders"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("authorization", "Basic c2tfdGVzdF80ZTI3MDA4ZTE0YzI0MTY0YmFkNmU3ZmRiZmRkOWRlZTo=")
                .method("POST", HttpRequest.BodyPublishers.ofString(pedidoString))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var pedidoCriado = response.body();
        log.info("Pedido criado com sucesso: \n" + pedidoCriado);

        var retornoPagarme = mapper.readValue(pedidoCriado, Order.class);
        var pedidoSalvo = savePedido(pedidoCriado, retornoPagarme, idCliente);

        log.info("Pedido salvo com sucesso: {}", pedidoSalvo);

        return retornoPagarme;
    }

    private Object savePedido(String retornoPagarme, Order retornoPagarmeObj, String idCliente) {
        PedidoEntity entity = new PedidoEntity();
        entity.setIdPedido(retornoPagarmeObj.getId());
        entity.setBody(retornoPagarme);
        entity.setIdCliente(idCliente);
        var pedidoSalvo = pagamentoRepository.save(entity);

        return pedidoSalvo;
    }

    @Override
    public Order get(long idOrder) {
        var retorno = pagamentoRepository.findById(idOrder);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(retorno, Order.class);
    }

    @Override
    public List<Order> getPedidosByCliente(String idCliente) throws JsonProcessingException {
        List<PedidoEntity> pedidos = pagamentoRepository.findAllByIdCliente(idCliente);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<Order> listaPedidos = new ArrayList<>();
        for(PedidoEntity entity : pedidos){
            listaPedidos.add(mapper.readValue(entity.getBody(), Order.class));
        }

        return listaPedidos;
    }

    @Override
    public List<Order> list(List<Long> ids) {
        List<PedidoEntity> pedidos = pagamentoRepository.findAllById(ids);
        ObjectMapper mapper = new ObjectMapper();
        List<Order> listaPedidos = new ArrayList<>();
        for(PedidoEntity entity : pedidos){
            listaPedidos.add(mapper.convertValue(entity, Order.class));
        }

        return listaPedidos;
    }

    @Override
    public String cancel(String idPedido) {
        return null;
    }

}
