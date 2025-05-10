package com.nexuscare.recipe.service;

import com.nexuscare.recipe.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Paciente save(Paciente paciente);
    Optional<Paciente> findById(Long id);
    List<Paciente> findAll();
    Paciente update(Long id, Paciente paciente);
    void delete(Long id);
}
