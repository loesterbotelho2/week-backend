package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
