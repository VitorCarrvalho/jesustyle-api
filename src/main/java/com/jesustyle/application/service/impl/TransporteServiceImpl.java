package com.jesustyle.application.service.impl;


import com.jesustyle.application.entidade.transporte.Simulacao;
import com.jesustyle.application.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;

@Service
public class TransporteServiceImpl implements TransporteService {

    private final RestTemplate restTemplate;

    @Autowired
    public TransporteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String simular(Simulacao simulacao) {
        String url = "https://portal.kangu.com.br/tms/transporte/simular";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("accept", "application/json");
            headers.set("token", "d2fbdabecf0c19213a5865ff5b4e9f629cb315e9a7db5519388afe71940a5aa5");
            headers.set("Content-Type", "application/json");
            headers.set("Cookie", "KANGUSESSID=p5ju2e8b0r7i9ef74fd94avmgn");

            HttpEntity<Simulacao> entity = new HttpEntity<>(simulacao, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);


            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Deu ruim família, e o erro foi esse ai ó: ",e);
        }
    }

    @Override
    public String solicitar(Simulacao simulacao) {
        return null;
    }

    @Override
    public String rastrear(Simulacao simulacao) {
        return null;
    }
}
