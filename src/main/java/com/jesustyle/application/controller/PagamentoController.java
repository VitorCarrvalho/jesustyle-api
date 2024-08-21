package com.jesustyle.application.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.entidade.pagamento.PedidoDTO;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.service.PagamentoService;
import com.jesustyle.application.service.TransporteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/pagamento")
@CrossOrigin("*")
@Tag(name = "Pagamento", description = "Gestão dos pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamento;

    @Autowired
    TransporteService transporteService;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/pedido")
    public ResponseEntity<Object> pedido(@RequestBody PedidoDTO pedidoDto) throws IOException, InterruptedException {
        Pedido pedido = mapper.convertValue(pedidoDto, Pedido.class);

       var pedidoCriado =  pagamento.criarPedido(pedido);

        if (Objects.nonNull(pedidoCriado) && pedidoCriado.getStatus().equals("paid")){
         var retornoTransporte = transporteService.solicitar(pedidoCriado, pedidoDto.getReferencia());
        return new ResponseEntity<>(pedidoCriado , HttpStatus.CREATED);
        }


        return new ResponseEntity<>("Erro ao processo novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<Object> consultaPedido(@RequestParam String idPedido) {
        var pedidoCriado =  pagamento.consultaPedido(idPedido);

        if (Objects.nonNull(pedidoCriado)){
            return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao consultar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/pedido/cancelar/{idPedido}")
    public ResponseEntity<Object> cancelaPedido(@RequestParam String idPedido) {
        var pedidoCriado =  pagamento.consultaPedido(idPedido);

        if (Objects.nonNull(pedidoCriado)){
            return new ResponseEntity<>(pedidoCriado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Erro ao cancelar novo pedido", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}