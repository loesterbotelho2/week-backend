package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.ReceitaMedicamentos;
import com.nexuscare.recipe.service.ConsultaIAService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ConsultaIAServiceImpl implements ConsultaIAService {

    private static final String API_KEY = "AIzaSyAR8cDPpoZMAyDYAqB3GoNxxqrUNgjfkf0";
    private final WebClient webClient;

    public ConsultaIAServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @Override
    public List<ReceitaMedicamentos> consultarIA(String observacoes) {
        String urlWithKey = "?key=" + API_KEY;

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", observacoes)
                        ))
                )
        );

        try {
            Mono<Map> response = webClient.post()
                    .uri(urlWithKey)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class);

            Map resposta = response.block();
            
            ReceitaMedicamentos receita = new ReceitaMedicamentos();

/*
            String textoResposta = ((Map)((List)((Map) resposta
            		.get("candidates"))
            		.get(0))
            		.get("content"))
                    .get("parts")
                    .toString();
*/
            
/*            
            
            receita.setMedicamento(textoResposta);
*/            
            
            

            return Collections.singletonList(receita);

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
