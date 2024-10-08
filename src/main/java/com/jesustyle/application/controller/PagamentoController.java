package com.jesustyle.application.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.entidade.pagamento.PedidoDTO;
import com.jesustyle.application.service.PagamentoService;
import com.jesustyle.application.service.TransporteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("/pagamento")
@CrossOrigin(origins = "https://jesustyleoficial.com.br", allowCredentials = "true")
@Tag(name = "Pagamento", description = "Gestão dos pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamento;

    @Autowired
    TransporteService transporteService;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/pedido")
    public ResponseEntity<Object> pedido(@RequestHeader("idCliente") String idCliente, @RequestBody PedidoDTO pedidoDto) throws IOException, InterruptedException {
        Pedido pedido = mapper.convertValue(pedidoDto, Pedido.class);

        log.info("Iniciando um novo pagamento para o cliente: {}", idCliente);
        var pedidoCriado = pagamento.create(pedido, idCliente);

        Map<String, Object> retornoPagamento = new HashMap<>();
        retornoPagamento.put("pagamento", pedidoCriado);

//        if (Objects.nonNull(pedidoCriado) && pedidoCriado.getStatus().equals("paid")) {
//            var retornoTransporte = transporteService.solicitar(pedidoCriado, pedidoDto.getReferencia(), pedidoDto);
//            retornoPagamento.put("transporte", retornoTransporte);
//            return new ResponseEntity<>(retornoPagamento, HttpStatus.CREATED);
//        }
        return new ResponseEntity<>(retornoPagamento, HttpStatus.CREATED);
        //return new ResponseEntity<>("Erro ao processo novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<Object> consultaPedido(@RequestParam long idPedido) {
        var pedidoCriado = pagamento.get(idPedido);

        if (Objects.nonNull(pedidoCriado)) {
            return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao consultar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/pedidos")
    public ResponseEntity<Object> listaPedidos(@RequestBody List<Long> ids) {
        var pedidoCriado = pagamento.list(ids);

        if (Objects.nonNull(pedidoCriado)) {
            return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao consultar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/pedidos/cliente")
    public ResponseEntity<Object> listaPedidosCliente(@RequestParam String idCliente) throws JsonProcessingException {
        var listaPedidos = pagamento.getPedidosByCliente(idCliente);

        if (Objects.nonNull(listaPedidos)) {
            return new ResponseEntity<>(listaPedidos, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao consultar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/pedido/cancelar/{idPedido}")
    public ResponseEntity<Object> cancelaPedido(@RequestParam String idPedido) {
        var pedidoCriado = pagamento.cancel(idPedido);

        if (Objects.nonNull(pedidoCriado)) {
            return new ResponseEntity<>(pedidoCriado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Erro ao cancelar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}