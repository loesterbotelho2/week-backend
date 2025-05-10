package com.nexuscare.recipe.controller;

import com.nexuscare.recipe.model.Cid;
import com.nexuscare.recipe.service.CidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cid")
public class CidController {

    private final CidService cidService;

    @Autowired
    public CidController(CidService cidService) {
        this.cidService = cidService;
    }

    @PostMapping
    public ResponseEntity<Cid> create(@RequestBody Cid cid) {
        Cid savedCid = cidService.save(cid);
        return ResponseEntity.ok(savedCid);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cid> getById(@PathVariable Long id) {
        Optional<Cid> cid = cidService.findById(id);
        return cid.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Cid> getAll() {
        return cidService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cid> update(@PathVariable Long id, @RequestBody Cid cid) {
        Cid updatedCid = cidService.update(id, cid);
        return updatedCid != null ? ResponseEntity.ok(updatedCid) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cidService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
