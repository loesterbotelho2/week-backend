package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoService {
    Medico save(Medico medico);
    Optional<Medico> findById(Long id);
    List<Medico> findAll();
    Medico update(Long id, Medico medico);
    void delete(Long id);
}
