package com.nexuscare.recipe.controller;

import com.nexuscare.recipe.model.ReceitaMedicamentos;
import com.nexuscare.recipe.service.ReceitaMedicamentosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receita-medicamentos")
public class ReceitaMedicamentosController {

    private final ReceitaMedicamentosService receitaMedicamentoService;
    
    @Autowired
    public ReceitaMedicamentosController(ReceitaMedicamentosService receitaMedicamentoService) {
        this.receitaMedicamentoService = receitaMedicamentoService;
    }
    
    
    @PostMapping
    public ResponseEntity<ReceitaMedicamentos> create(@RequestBody ReceitaMedicamentos receitaMedicamentos) {
        ReceitaMedicamentos savedReceitaMedicamento = receitaMedicamentoService.save(receitaMedicamentos);
        return ResponseEntity.ok(savedReceitaMedicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaMedicamentos> getById(@PathVariable Long id) {
        Optional<ReceitaMedicamentos> receitaMedicamentos = receitaMedicamentoService.findById(id);
        return receitaMedicamentos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ReceitaMedicamentos> getAll() {
        return receitaMedicamentoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaMedicamentos> update(@PathVariable Long id, @RequestBody ReceitaMedicamentos receitaMedicamentos) {
        ReceitaMedicamentos updatedReceitaMedicamento = receitaMedicamentoService.update(id, receitaMedicamentos);
        return updatedReceitaMedicamento != null ? ResponseEntity.ok(updatedReceitaMedicamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        receitaMedicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}