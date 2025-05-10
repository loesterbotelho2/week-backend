package com.nexuscare.recipe.controller;

import com.nexuscare.recipe.model.ReceitaMedicamentos;
import com.nexuscare.recipe.service.ConsultaIAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta-ia")
public class ConsultaIAController {

    private final ConsultaIAService consultaIAService;

    @Autowired
    public ConsultaIAController(ConsultaIAService consultaIAService) {
        this.consultaIAService = consultaIAService;
    }

    @PostMapping
    public ResponseEntity<List<ReceitaMedicamentos>> consultar(@RequestBody String observacoes) {
        List<ReceitaMedicamentos> resultados = consultaIAService.consultarIA(observacoes);
        return ResponseEntity.ok(resultados);
    }
}
