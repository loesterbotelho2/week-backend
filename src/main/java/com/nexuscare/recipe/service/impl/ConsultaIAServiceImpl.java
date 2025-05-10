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
         
	        List<Map<String, Object>> candidates = (List<Map<String, Object>>) resposta.get("candidates");
	        
	        Map<String, Object> primeiroCandidato = candidates.get(0);
	        
	        Map<String, Object> content = (Map<String, Object>) primeiroCandidato.get("content");
	        
	        
	        List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
	        String textoResposta = parts.get(0).get("text").toString();

	        String limpo = textoResposta.replace("```json", "").replace("```", "").trim();
	        
	        try {
	        	lista = objectMapper.readValue(limpo, new TypeReference<List<NomeMedicamentos>>() {});
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
		

		StringBuilder sb = new StringBuilder();

		sb.append("Por favor, gere uma receita médica fictícia em formato JSON para uma pessoa com diagnóstico de \""+observacoes+"\", apresentando sintomas como pulmão com chiado, batimentos acelerados e fraqueza. Caso o paciente tenha alguma alergia medicamentosa, ajuste os medicamentos conforme necessário. Se não encontrar medicamentos apropriados para o caso, retorne um JSON vazio. A resposta deve conter apenas o JSON, sem adicionar nenhum texto, explicação ou delimitadores como ```json ou ```. Use exatamente o formato abaixo:");
			
		sb.append("\n");
		
		sb.append("[");
		sb.append("{\"receita_id\":0,\"medicamento_id\":1,\"dosagem\":\"10mg\",\"quantidade\":5,\"instrucoes\":\"Tomar 1 comprimido por dia, de manhã\",\"id\":\"f695\"},");
		sb.append("{\"receita_id\":0,\"medicamento_id\":2,\"dosagem\":\"500mg\",\"quantidade\":10,\"instrucoes\":\"Tomar 1 comprimido a cada 12 horas por 7 dias\",\"id\":\"edae\"},");
		sb.append("{\"receita_id\":0,\"medicamento_id\":3,\"dosagem\":\"200mcg\",\"quantidade\":6,\"instrucoes\":\"Inalar 2 jatos pela manhã e à noite\",\"id\":\"b1b1\"},");
		sb.append("{\"receita_id\":0,\"medicamento_id\":4,\"dosagem\":\"100mcg\",\"quantidade\":3,\"instrucoes\":\"Inalar 2 jatos em caso de crise de asma\",\"id\":\"177c\"},");
		sb.append("{\"receita_id\":0,\"medicamento_id\":5,\"dosagem\":\"200mcg\",\"quantidade\":6,\"instrucoes\":\"Inalar 2 jatos conforme necessidade para crises asmáticas\",\"id\":\"8f62\"}");
		sb.append("]");

		prompt = sb.toString();

		return prompt;
	}
}
