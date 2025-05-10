package com.nexuscare.recipe.service.impl;

import com.nexuscare.recipe.model.ReceitaMedicamentos;
import com.nexuscare.recipe.service.ConsultaIAService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexuscare.recipe.model.NomeMedicamentos;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
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

    
    @SuppressWarnings("unchecked")
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
            @SuppressWarnings("rawtypes")
			Mono<Map> response = webClient.post()
                    .uri(urlWithKey)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class);

           
            
            ReceitaMedicamentos receita = new ReceitaMedicamentos();
            List<NomeMedicamentos> lista = new ArrayList<NomeMedicamentos>();
            ObjectMapper objectMapper = new ObjectMapper();
            
            @SuppressWarnings("rawtypes")
			Map resposta = response.block();
           
/*
            String textoResposta = ((Map)((List)((Map) resposta
                    .get("candidates"))
                    .get(0))
                    .get("content"))
                    .get("parts")
                    .toString();
*/            
            
	        List<Map<String, Object>> candidates = (List<Map<String, Object>>) resposta.get("candidates");
	        
	        Map<String, Object> primeiroCandidato = candidates.get(0);
	        
	        Map<String, Object> content = (Map<String, Object>) primeiroCandidato.get("content");
	        
	        
	        List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
	        String textoResposta = parts.get(0).get("text").toString();

	        try {
	        	lista = objectMapper.readValue(textoResposta, new TypeReference<List<NomeMedicamentos>>() {});
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ArrayList<>();
	        }
            
            for (NomeMedicamentos item : lista) {
                receita.setMedicamento(item);
            }

            return Collections.singletonList(receita);

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


	@Override
	public String gerarPrompt(String observacoes) {
		String prompt = "";
		prompt += observacoes;

		return prompt;
	}
}
