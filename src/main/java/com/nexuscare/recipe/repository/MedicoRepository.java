package com.nexuscare.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexuscare.recipe.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
