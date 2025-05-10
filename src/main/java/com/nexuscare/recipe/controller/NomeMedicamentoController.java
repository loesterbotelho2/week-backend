package com.nexuscare.recipe.controller;

import com.nexuscare.recipe.model.NomeMedicamento;
import com.nexuscare.recipe.service.NomeMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nome-medicamentos")
public class NomeMedicamentoController {

    private final NomeMedicamentoService NomeMedicamentoService;

    @Autowired
    public NomeMedicamentoController(NomeMedicamentoService NomeMedicamentoService) {
        this.NomeMedicamentoService = NomeMedicamentoService;
    }

    @PostMapping
    public ResponseEntity<NomeMedicamento> create(@RequestBody NomeMedicamento NomeMedicamento) {
        NomeMedicamento savedMedicamento = NomeMedicamentoService.save(NomeMedicamento);
        return ResponseEntity.ok(savedMedicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NomeMedicamento> getById(@PathVariable Long id) {
        Optional<NomeMedicamento> NomeMedicamento = NomeMedicamentoService.findById(id);
        return NomeMedicamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<NomeMedicamento> getAll() {
        return NomeMedicamentoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NomeMedicamento> update(@PathVariable Long id, @RequestBody NomeMedicamento NomeMedicamento) {
        NomeMedicamento updatedMedicamento = NomeMedicamentoService.update(id, NomeMedicamento);
        return updatedMedicamento != null ? ResponseEntity.ok(updatedMedicamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        NomeMedicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
