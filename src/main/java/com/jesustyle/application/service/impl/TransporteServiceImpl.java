package com.jesustyle.application.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.request.Simulacao;
import com.jesustyle.application.entidade.transporte.response.SimulacaoResponse;
import com.jesustyle.application.service.TransporteService;
import com.jesustyle.application.util.EnviarEmailServiceImpl;
import com.jesustyle.application.util.MapOrderToTransporte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;


import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class TransporteServiceImpl implements TransporteService {

    private static final  String URL_BASE = "https://portal.kangu.com.br/tms";

    private static final String KEY_TRANSPORTE = "d2fbdabecf0c19213a5865ff5b4e9f629cb315e9a7db5519388afe71940a5aa5";
    private final RestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MapOrderToTransporte mapOrderToTransporte;

    @Autowired
    EnviarEmailServiceImpl enviarEmailService;

    @Autowired
    public TransporteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SimulacaoResponse simular(Simulacao simulacao) {

        String url = URL_BASE + "/transporte/simular";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(dateFormat);
        objectMapper.registerModule(new JavaTimeModule());

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("accept", "application/json");
            headers.set("token", KEY_TRANSPORTE);
            headers.set("Content-Type", "application/json");
            headers.set("Cookie", "KANGUSESSID=p5ju2e8b0r7i9ef74fd94avmgn");

            HttpEntity<Simulacao> entity = new HttpEntity<>(simulacao, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            SimulacaoResponse[] simulacoesArray = objectMapper.readValue(response.getBody(), SimulacaoResponse[].class);


            List<SimulacaoResponse> simulacoesList = Arrays.asList(simulacoesArray);

            SimulacaoResponse simulacaoEscolhida = new SimulacaoResponse();
            for (SimulacaoResponse s : simulacoesList){
                if(s.getIdTransp() == 9900 || s.getIdTransp() == 28719){
                    simulacaoEscolhida = s;
                    break;
                }
            }
            simulacaoEscolhida.setPrazoEnt(simulacaoEscolhida.getPrazoEnt() + 2);
            log.info("Tarifa selecionada: "+ simulacaoEscolhida.getReferencia());
            return simulacaoEscolhida;

        } catch (Exception e) {
            throw new RuntimeException("Deu ruim família, e o erro foi esse ai ó: ",e);
        }
    }

    @Override
    public String solicitar(Order pedidoAprovado, String referencia) {
        var solicitacaoTransporte =
                mapOrderToTransporte.mapOrderToTransporteRequest(pedidoAprovado, referencia);

        String url = URL_BASE + "/transporte/solicitar";

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("token", KEY_TRANSPORTE);

        HttpEntity<Object> entity = new HttpEntity<>(solicitacaoTransporte, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        if(response.getStatusCode().is2xxSuccessful()){
            enviarEmail(pedidoAprovado);
        }
        return response.getBody();

    }

    private void enviarEmail(Order pedidoAprovado) {
        enviarEmailService.enviar(pedidoAprovado);
    }

    @Override
    public String rastrear(Simulacao simulacao) {
        return null;
    }

    @Override
    public String imprimirEtiqueta(String codRastreio) {
        String url = URL_BASE + "/transporte/imprimir-etiqueta/" + codRastreio;

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("token", KEY_TRANSPORTE);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
