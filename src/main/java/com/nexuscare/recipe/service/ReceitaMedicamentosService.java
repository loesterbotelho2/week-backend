package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.ReceitaMedicamentos;
import java.util.List;
import java.util.Optional;

public interface ReceitaMedicamentosService {
    ReceitaMedicamentos save(ReceitaMedicamentos receitaMedicamentos);
    Optional<ReceitaMedicamentos> findById(Long id);
    List<ReceitaMedicamentos> findAll();
    ReceitaMedicamentos update(Long id, ReceitaMedicamentos receitaMedicamentos);
    void delete(Long id);
}
