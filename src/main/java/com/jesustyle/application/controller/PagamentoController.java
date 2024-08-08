package com.jesustyle.application.controller;


import com.jesustyle.application.entidade.pagamento.Pedido;
import com.jesustyle.application.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/pagamento")
@Tag(name = "Plant", description = "PAgamento")
public class PagamentoController {

    @Autowired
    PagamentoService pagamento;

    @PostMapping("/pedido")
    public ResponseEntity<Object> pedido(@RequestBody Pedido pedido) throws IOException, InterruptedException {
       var pedidoCriado =  pagamento.criarPedido(pedido);

        if (Objects.nonNull(pedidoCriado)){
            return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
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