package com.jesustyle.application.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesustyle.application.entidade.pagamento.PedidoDTO;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.solicitar.request.Pedido;
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
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
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

    @PostMapping("/pedido/{idUsuario}")
    public ResponseEntity<Object> pedido(@RequestBody PedidoDTO pedidoDto, @PathVariable("idUsuario") String idUsuario) throws IOException, InterruptedException {
        Pedido pedido = mapper.convertValue(pedidoDto, Pedido.class);

        var pedidoCriado = pagamento.criarPedido(pedido);

        Map<String, Object> retornoPagamento = new HashMap<>();
        retornoPagamento.put("pagamento", pedidoCriado);
        //cartão crédito aprovado retorna paid
        if (Objects.nonNull(pedidoCriado) && pedidoCriado.getStatus().equals("paid")) {
            var retornoTransporte = transporteService.solicitar(pedidoCriado, pedidoDto.getReferencia(), pedidoDto);
            retornoPagamento.put("transporte", retornoTransporte);
            return new ResponseEntity<>(retornoPagamento, HttpStatus.CREATED);
        }
        //cartão pix aprovado retorna waiting_payment
        if (Objects.nonNull(pedidoCriado) && pedidoCriado.getStatus().equals("waiting_payment")) {
            log.info("pedido realizado com Pix, aguardano pagamento! pedido: {}" , pedidoCriado.getId());
            return new ResponseEntity<>(retornoPagamento, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(retornoPagamento, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<Object> consultaPedido(@RequestParam String idPedido) {
        var pedidoCriado = pagamento.consultaPedido(idPedido);

        if (Objects.nonNull(pedidoCriado)) {
            return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao consultar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/pedido/cancelar/{idPedido}")
    public ResponseEntity<Object> cancelaPedido(@RequestParam String idPedido) {
        var pedidoCriado = pagamento.consultaPedido(idPedido);

        if (Objects.nonNull(pedidoCriado)) {
            return new ResponseEntity<>(pedidoCriado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Erro ao cancelar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}