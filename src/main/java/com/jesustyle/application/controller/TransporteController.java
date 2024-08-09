package com.jesustyle.application.controller;

import com.jesustyle.application.entidade.transporte.Simulacao;
import com.jesustyle.application.entidade.transporte.SimulacaoResp;
import com.jesustyle.application.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/transporte")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;
    @GetMapping("/simular")
    public ResponseEntity<Object> cadastro(@RequestBody Simulacao simulacao){

        var frete = transporteService.simular(simulacao);

        if(Objects.nonNull(frete)){
            return new ResponseEntity<>(frete, HttpStatus.OK);
        }
        return new ResponseEntity<>("Simulação temporariamente indisponível", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/etiqueta")
    public ResponseEntity<Object> cadastro(@RequestBody String codRastreio){

        var frete = transporteService.imprimirEtiqueta(codRastreio);

        if(Objects.nonNull(frete)){
            return new ResponseEntity<>(frete, HttpStatus.OK);
        }
        return new ResponseEntity<>("Simulação temporariamente indisponível", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
