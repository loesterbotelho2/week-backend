package com.nexuscare.recipe.controller;

import com.nexuscare.recipe.model.NomeMedicamentos;
import com.nexuscare.recipe.service.NomeMedicamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nome-medicamentos")
public class NomeMedicamentosController {

    private final NomeMedicamentosService NomeMedicamentoService;

    @Autowired
    public NomeMedicamentosController(NomeMedicamentosService NomeMedicamentoService) {
        this.NomeMedicamentoService = NomeMedicamentoService;
    }

    @PostMapping
    public ResponseEntity<NomeMedicamentos> create(@RequestBody NomeMedicamentos NomeMedicamento) {
        NomeMedicamentos savedMedicamento = NomeMedicamentoService.save(NomeMedicamento);
        return ResponseEntity.ok(savedMedicamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NomeMedicamentos> getById(@PathVariable Long id) {
        Optional<NomeMedicamentos> NomeMedicamento = NomeMedicamentoService.findById(id);
        return NomeMedicamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<NomeMedicamentos> getAll() {
        return NomeMedicamentoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NomeMedicamentos> update(@PathVariable Long id, @RequestBody NomeMedicamentos NomeMedicamento) {
        NomeMedicamentos updatedMedicamento = NomeMedicamentoService.update(id, NomeMedicamento);
        return updatedMedicamento != null ? ResponseEntity.ok(updatedMedicamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        NomeMedicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
