package com.jesustyle.application.controller;

import com.jesustyle.application.entidade.transporte.request.Simulacao;
import com.jesustyle.application.service.TransporteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/transporte")
@CrossOrigin(origins = "*")
@Tag(name = "Transporte", description = "Integração dos pedidos com a Kangu")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;
    @PostMapping("/simular")
    public ResponseEntity<Object> cadastro(@RequestBody Simulacao simulacao){

        var frete = transporteService.simular(simulacao);

        if(Objects.nonNull(frete)){
            log.info("Simulação de frete realizada com sucesso!");
            return new ResponseEntity<>(frete, HttpStatus.OK);
        }
        return new ResponseEntity<>("Simulação temporariamente indisponível", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/etiqueta/{codRastreio}")
    public ResponseEntity<Object> cadastro(@PathVariable String codRastreio){

        var frete = transporteService.imprimirEtiqueta(codRastreio);

        if(Objects.nonNull(frete)){
            return new ResponseEntity<>(frete, HttpStatus.OK);
        }
        return new ResponseEntity<>("Simulação temporariamente indisponível", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
