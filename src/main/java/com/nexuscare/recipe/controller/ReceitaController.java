package com.nexuscare.recipe.controller;

import com.nexuscare.recipe.model.Receita;
import com.nexuscare.recipe.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    @Autowired
    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody Receita receita) {
        Receita savedReceita = receitaService.save(receita);
        return ResponseEntity.ok(savedReceita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable Long id) {
        Optional<Receita> receita = receitaService.findById(id);
        return receita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Receita> getAll() {
        return receitaService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> update(@PathVariable Long id, @RequestBody Receita receita) {
        Receita updatedReceita = receitaService.update(id, receita);
        return updatedReceita != null ? ResponseEntity.ok(updatedReceita) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        receitaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
